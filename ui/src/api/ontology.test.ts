import { afterEach, describe, expect, it, vi } from 'vitest'
import { createOntology, createOntologyClass, listOntologies, releaseOntology } from './ontology'

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
})
