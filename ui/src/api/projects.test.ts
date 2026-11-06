import { afterEach, describe, expect, it, vi } from 'vitest'
import { changeProjectStatus, createProject, getProject, listProjects, updateProject } from './projects'

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

  it('updates project details and changes status', async () => {
    vi.stubGlobal('fetch', vi.fn()
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'p-1', name: 'Updated', status: 'DRAFT' }), { status: 200 }))
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'p-1', name: 'Updated', status: 'DRAFT' }), { status: 200 }))
      .mockResolvedValueOnce(new Response(JSON.stringify({ id: 'p-1', name: 'Updated', status: 'ACTIVE' }), { status: 200 })))

    await expect(getProject('p-1')).resolves.toMatchObject({ id: 'p-1', name: 'Updated' })
    await expect(updateProject('p-1', { name: 'Updated', description: 'Details' })).resolves.toMatchObject({ name: 'Updated' })
    await expect(changeProjectStatus('p-1', 'ACTIVE')).resolves.toMatchObject({ status: 'ACTIVE' })
    expect(fetch).toHaveBeenCalledWith('/api/v1/projects/p-1', expect.objectContaining({ method: 'GET' }))
  })
})
