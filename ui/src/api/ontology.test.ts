import { afterEach, describe, expect, it, vi } from 'vitest'
import { createOntology, createOntologyClass, createOntologyProperty, createOntologyRelation, listOntologyProperties, listOntologyReleases, listOntologyRelations, listOntologies, releaseOntology } from './ontology'

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
})
