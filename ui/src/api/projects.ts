import { authorizationHeader, type AuthCredentials } from './auth'

export type ProjectStatus = 'DRAFT' | 'ACTIVE' | 'ARCHIVED'

export interface Project {
  id: string
  name: string
  description?: string | null
  status: ProjectStatus
  createdAt?: string
  updatedAt?: string
}

export interface CreateProjectRequest {
  name: string
  description?: string
}

const apiOrigin = (import.meta.env.VITE_ENTLOOM_API_BASE_URL ?? '').replace(/\/$/, '')
const projectsEndpoint = `${apiOrigin}/api/v1/projects`
const projectEndpoint = (id: string) => `${projectsEndpoint}/${id}`

async function readJson<T>(response: Response): Promise<T> {
  if (!response.ok) {
    const detail = await response.text()
    throw new Error(detail || `Entloom API request failed with status ${response.status}`)
  }
  return response.json() as Promise<T>
}

export async function listProjects(credentials?: AuthCredentials): Promise<Project[]> {
  const response = await fetch(projectsEndpoint, {
    method: 'GET',
    headers: {
      Accept: 'application/json',
      ...(credentials ? { Authorization: authorizationHeader(credentials) } : {}),
    },
  })
  return readJson<Project[]>(response)
}

export async function createProject(request: CreateProjectRequest, credentials?: AuthCredentials): Promise<Project> {
  const response = await fetch(projectsEndpoint, {
    method: 'POST',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
      ...(credentials ? { Authorization: authorizationHeader(credentials) } : {}),
    },
    body: JSON.stringify(request),
  })
  return readJson<Project>(response)
}

export async function getProject(id: string, credentials?: AuthCredentials): Promise<Project> {
  const response = await fetch(projectEndpoint(id), {
    method: 'GET',
    headers: {
      Accept: 'application/json',
      ...(credentials ? { Authorization: authorizationHeader(credentials) } : {}),
    },
  })
  return readJson<Project>(response)
}

export async function updateProject(
  id: string,
  request: CreateProjectRequest,
  credentials?: AuthCredentials,
): Promise<Project> {
  const response = await fetch(projectEndpoint(id), {
    method: 'PATCH',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
      ...(credentials ? { Authorization: authorizationHeader(credentials) } : {}),
    },
    body: JSON.stringify(request),
  })
  return readJson<Project>(response)
}

export async function changeProjectStatus(
  id: string,
  status: ProjectStatus,
  credentials?: AuthCredentials,
): Promise<Project> {
  const response = await fetch(`${projectEndpoint(id)}/status`, {
    method: 'PATCH',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
      ...(credentials ? { Authorization: authorizationHeader(credentials) } : {}),
    },
    body: JSON.stringify({ status }),
  })
  return readJson<Project>(response)
}
