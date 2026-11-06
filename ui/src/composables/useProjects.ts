import { ref, type Ref } from 'vue'
import type { AuthCredentials } from '../api/auth'
import {
  changeProjectStatus,
  createProject,
  listProjects,
  updateProject,
  type CreateProjectRequest,
  type Project,
  type ProjectStatus,
} from '../api/projects'

export function useProjects(credentials?: Ref<AuthCredentials | null>) {
  const projects = ref<Project[]>([])
  const loading = ref(false)
  const creating = ref(false)
  const error = ref('')

  async function load() {
    loading.value = true
    error.value = ''
    try {
      projects.value = await listProjects(credentials?.value ?? undefined)
    } catch (cause) {
      error.value = cause instanceof Error ? cause.message : 'Unable to load projects'
    } finally {
      loading.value = false
    }
  }

  async function create(request: CreateProjectRequest) {
    creating.value = true
    error.value = ''
    try {
      const project = await createProject(request, credentials?.value ?? undefined)
      projects.value = [project, ...projects.value]
      return project
    } catch (cause) {
      error.value = cause instanceof Error ? cause.message : 'Unable to create project'
      return undefined
    } finally {
      creating.value = false
    }
  }

  async function update(id: string, request: CreateProjectRequest) {
    error.value = ''
    try {
      const project = await updateProject(id, request, credentials?.value ?? undefined)
      projects.value = projects.value.map((item) => item.id === id ? project : item)
      return project
    } catch (cause) {
      error.value = cause instanceof Error ? cause.message : 'Unable to update project'
      return undefined
    }
  }

  async function changeStatus(id: string, status: ProjectStatus) {
    error.value = ''
    try {
      const project = await changeProjectStatus(id, status, credentials?.value ?? undefined)
      projects.value = projects.value.map((item) => item.id === id ? project : item)
      return project
    } catch (cause) {
      error.value = cause instanceof Error ? cause.message : 'Unable to change project status'
      return undefined
    }
  }

  return {
    projects,
    loading,
    creating,
    error,
    load,
    create,
    update,
    changeStatus,
  }
}
