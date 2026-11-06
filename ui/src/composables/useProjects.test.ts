import { beforeEach, describe, expect, it, vi } from 'vitest'
import { createProject, listProjects } from '../api/projects'
import { useProjects } from './useProjects'

vi.mock('../api/projects', () => ({
  createProject: vi.fn(),
  listProjects: vi.fn(),
}))

const mockedListProjects = vi.mocked(listProjects)
const mockedCreateProject = vi.mocked(createProject)

describe('useProjects', () => {
  beforeEach(() => {
    vi.clearAllMocks()
  })

  it('loads projects and exposes loading state', async () => {
    mockedListProjects.mockResolvedValue([
      { id: 'p-1', name: 'Library model', description: null, status: 'DRAFT' },
    ])
    const state = useProjects()

    const loading = state.load()
    expect(state.loading.value).toBe(true)
    await loading

    expect(state.loading.value).toBe(false)
    expect(state.projects.value[0]?.name).toBe('Library model')
    expect(state.error.value).toBe('')
  })

  it('keeps a readable error when loading fails', async () => {
    mockedListProjects.mockRejectedValue(new Error('Server unavailable'))
    const state = useProjects()

    await state.load()

    expect(state.loading.value).toBe(false)
    expect(state.projects.value).toEqual([])
    expect(state.error.value).toBe('Server unavailable')
  })

  it('prepends a newly created project', async () => {
    mockedCreateProject.mockResolvedValue({
      id: 'p-2',
      name: 'Agent map',
      description: 'First project',
      status: 'DRAFT',
    })
    const state = useProjects()
    state.projects.value = [{ id: 'p-1', name: 'Library model', description: null, status: 'DRAFT' }]

    await state.create({ name: 'Agent map', description: 'First project' })

    expect(state.projects.value.map((project) => project.id)).toEqual(['p-2', 'p-1'])
    expect(state.error.value).toBe('')
  })
})
