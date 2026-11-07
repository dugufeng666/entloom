import { afterEach, describe, expect, it, vi } from 'vitest'
import { changeOntologyStatus, compareOntologyReleases, createOntology, createOntologyClass, createOntologyProperty, createOntologyRelation, deleteOntologyClass, forkOntology, listOntologyProperties, listOntologyReleases, listOntologyRelations, listOntologies, releaseOntology, updateOntologyProperty, validateOntology } from './ontology'

describe('ontology API client', () => {
  afterEach(() => vi.restoreAllMocks())

  it('creates an ontology and class through the project scope', async () => {
    vi.stubGlobal('fetch', vi.fn()
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'o-1', projectId: 'p-1', name: 'Customer', status: 'DRAFT' }), { status: 201 }))
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'c-1', ontologyId: 'o-1', name: 'Customer' }), { status: 201 })))

    await expect(createOntology('p-1', 'Customer', '')).resolves.toMatchObject({ id: 'o-1' })
    await expect(createOntologyClass('p-1', 'o-1', 'Customer', '')).resolves.toMatchObject({ id: 'c-1' })
    expect(fetch).toHaveBeenCalledWith('/api/v1/projects/p-1/ontologies', expect.objectContaining({ method: 'POST' }))
  })

  it('lists and releases an ontology', async () => {
    vi.stubGlobal('fetch', vi.fn()
      .mockResolvedValueOnce(new Response(JSON.stringify([{ id: 'o-1', projectId: 'p-1', name: 'Customer', status: 'DRAFT' }]), { status: 200 }))
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'r-1', ontologyId: 'o-1', version: '0.1.0' }), { status: 201 })))

    await expect(listOntologies('p-1')).resolves.toHaveLength(1)
    await expect(releaseOntology('p-1', 'o-1', '0.1.0')).resolves.toMatchObject({ version: '0.1.0' })
  })

  it('covers properties, relations and release history endpoints', async () => {
    vi.stubGlobal('fetch', vi.fn()
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'prop-1', valueType: 'TEXT', required: true }), { status: 201 }))
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'rel-1', cardinality: 'ONE_TO_MANY' }), { status: 201 }))
      .mockResolvedValueOnce(new Response(JSON.stringify([{ id: 'prop-1', valueType: 'TEXT', required: true }]), { status: 200 }))
      .mockResolvedValueOnce(new Response(JSON.stringify([{ id: 'rel-1', cardinality: 'ONE_TO_MANY' }]), { status: 200 }))
      .mockResolvedValueOnce(new Response(JSON.stringify([{ id: 'r-1', version: '0.1.0', classCount: 2, propertyCount: 1, relationCount: 1 }]), { status: 200 })))

    await expect(createOntologyProperty('p-1', 'o-1', 'c-1', { name: 'email', description: '', valueType: 'TEXT', required: true })).resolves.toMatchObject({ id: 'prop-1' })
    await expect(createOntologyRelation('p-1', 'o-1', { name: 'owns', description: '', sourceClassId: 'c-1', targetClassId: 'c-2', cardinality: 'ONE_TO_MANY' })).resolves.toMatchObject({ id: 'rel-1' })
    await expect(listOntologyProperties('p-1', 'o-1', 'c-1')).resolves.toHaveLength(1)
    await expect(listOntologyRelations('p-1', 'o-1')).resolves.toHaveLength(1)
    await expect(listOntologyReleases('p-1', 'o-1')).resolves.toHaveLength(1)
  })

  it('compares releases and supports draft deletion requests', async () => {
    vi.stubGlobal('fetch', vi.fn()
      .mockResolvedValueOnce(new Response(JSON.stringify({ fromVersion: '1.0.0', toVersion: '2.0.0', changes: [{ itemId: 'c-1', changeType: 'MODIFIED', kind: 'CLASS', name: 'Customer' }] }), { status: 200 }))
      .mockResolvedValueOnce(new Response(null, { status: 204 }))
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'o-1', status: 'DRAFT' }), { status: 200 })))

    await expect(compareOntologyReleases('p-1', 'o-1', 'r-1', 'r-2')).resolves.toMatchObject({ fromVersion: '1.0.0' })
    await expect(deleteOntologyClass('p-1', 'o-1', 'c-1')).resolves.toBeUndefined()
    await expect(changeOntologyStatus('p-1', 'o-1', 'DRAFT')).resolves.toMatchObject({ status: 'DRAFT' })
  })

  it('validates, forks and edits a model resource', async () => {
    vi.stubGlobal('fetch', vi.fn()
      .mockResolvedValueOnce(new Response(JSON.stringify({ valid: false, issues: [{ severity: 'ERROR', code: 'NO_CLASSES', message: 'Add a class', location: 'ontology' }] }), { status: 200 }))
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'o-2', name: 'Fork', status: 'DRAFT' }), { status: 201 }))
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'prop-1', name: 'email', valueType: 'TEXT', required: true }), { status: 200 })))

    await expect(validateOntology('p-1', 'o-1')).resolves.toMatchObject({ valid: false })
    await expect(forkOntology('p-1', 'o-1', 'Fork', '')).resolves.toMatchObject({ id: 'o-2' })
    await expect(updateOntologyProperty('p-1', 'o-1', 'c-1', 'prop-1', { name: 'email', description: '', valueType: 'TEXT', required: true })).resolves.toMatchObject({ name: 'email' })
  })
})
