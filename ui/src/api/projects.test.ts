import { afterEach, describe, expect, it, vi } from 'vitest'
import { createProject, listProjects } from './projects'

describe('projects API client', () => {
  afterEach(() => vi.restoreAllMocks())

  it('lists projects from the versioned server endpoint', async () => {
    vi.stubGlobal('fetch', vi.fn().mockResolvedValue(
      new Response(JSON.stringify([{ id: 'p-1', name: 'Library model', status: 'DRAFT' }]), {
        status: 200,
        headers: { 'Content-Type': 'application/json' },
      }),
    ))

    await expect(listProjects()).resolves.toEqual([
      { id: 'p-1', name: 'Library model', status: 'DRAFT' },
    ])
    expect(fetch).toHaveBeenCalledWith('/api/v1/projects', expect.objectContaining({ method: 'GET' }))
  })

  it('creates a project with a JSON request', async () => {
    vi.stubGlobal('fetch', vi.fn().mockResolvedValue(
      new Response(JSON.stringify({ id: 'p-2', name: 'Agent map', status: 'DRAFT' }), {
        status: 201,
        headers: { 'Content-Type': 'application/json' },
      }),
    ))

    await expect(createProject({ name: 'Agent map', description: 'First project' })).resolves.toMatchObject({
      id: 'p-2',
      name: 'Agent map',
    })
    expect(fetch).toHaveBeenCalledWith('/api/v1/projects', expect.objectContaining({ method: 'POST' }))
  })
})
