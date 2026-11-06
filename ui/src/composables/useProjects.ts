import { ref } from 'vue'
import {
  createProject,
  listProjects,
  type CreateProjectRequest,
  type Project,
} from '../api/projects'

export function useProjects() {
  const projects = ref<Project[]>([])
  const loading = ref(false)
  const creating = ref(false)
  const error = ref('')

  async function load() {
    loading.value = true
    error.value = ''
    try {
      projects.value = await listProjects()
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
      const project = await createProject(request)
      projects.value = [project, ...projects.value]
      return project
    } catch (cause) {
      error.value = cause instanceof Error ? cause.message : 'Unable to create project'
      return undefined
    } finally {
      creating.value = false
    }
  }

  return {
    projects,
    loading,
    creating,
    error,
    load,
    create,
  }
}
