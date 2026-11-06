import { authorizationHeader, type AuthCredentials } from './auth'

export type OntologyStatus = 'DRAFT' | 'RELEASED' | 'ARCHIVED'
export interface Ontology { id: string; projectId: string; name: string; description?: string | null; status: OntologyStatus }
export interface OntologyClass { id: string; ontologyId: string; name: string; description?: string | null }
export type OntologyPropertyValueType = 'TEXT' | 'NUMBER' | 'BOOLEAN' | 'DATE' | 'REFERENCE'
export type OntologyRelationCardinality = 'ONE_TO_ONE' | 'ONE_TO_MANY' | 'MANY_TO_ONE' | 'MANY_TO_MANY'
export interface OntologyProperty { id: string; ontologyId: string; classId: string; name: string; description?: string | null; valueType: OntologyPropertyValueType; required: boolean }
export interface OntologyRelation { id: string; ontologyId: string; sourceClassId: string; targetClassId: string; name: string; description?: string | null; cardinality: OntologyRelationCardinality }
export interface OntologyRelease { id: string; ontologyId: string; version: string; notes?: string | null; releasedBy?: string; releasedAt?: string; classCount: number; propertyCount: number; relationCount: number }

const apiOrigin = (import.meta.env.VITE_ENTLOOM_API_BASE_URL ?? '').replace(/\/$/, '')
const endpoint = (projectId: string) => `${apiOrigin}/api/v1/projects/${projectId}/ontologies`

async function readJson<T>(response: Response): Promise<T> {
  if (!response.ok) throw new Error((await response.text()) || `Entloom API request failed with status ${response.status}`)
  return response.json() as Promise<T>
}

function authHeaders(credentials?: AuthCredentials): Record<string, string> {
  return credentials ? { Authorization: authorizationHeader(credentials) } : {}
}

export async function listOntologies(projectId: string, credentials?: AuthCredentials) {
  return readJson<Ontology[]>(await fetch(endpoint(projectId), { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function createOntology(projectId: string, name: string, description: string, credentials?: AuthCredentials) {
  return readJson<Ontology>(await fetch(endpoint(projectId), { method: 'POST', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify({ name, description }) }))
}

export async function listOntologyClasses(projectId: string, ontologyId: string, credentials?: AuthCredentials) {
  return readJson<OntologyClass[]>(await fetch(`${endpoint(projectId)}/${ontologyId}/classes`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function createOntologyClass(projectId: string, ontologyId: string, name: string, description: string, credentials?: AuthCredentials) {
  return readJson<OntologyClass>(await fetch(`${endpoint(projectId)}/${ontologyId}/classes`, { method: 'POST', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify({ name, description }) }))
}

export async function listOntologyProperties(projectId: string, ontologyId: string, classId: string, credentials?: AuthCredentials) {
  return readJson<OntologyProperty[]>(await fetch(`${endpoint(projectId)}/${ontologyId}/classes/${classId}/properties`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function createOntologyProperty(projectId: string, ontologyId: string, classId: string, input: Pick<OntologyProperty, 'name' | 'description' | 'valueType' | 'required'>, credentials?: AuthCredentials) {
  return readJson<OntologyProperty>(await fetch(`${endpoint(projectId)}/${ontologyId}/classes/${classId}/properties`, { method: 'POST', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify(input) }))
}

export async function listOntologyRelations(projectId: string, ontologyId: string, credentials?: AuthCredentials) {
  return readJson<OntologyRelation[]>(await fetch(`${endpoint(projectId)}/${ontologyId}/relations`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function createOntologyRelation(projectId: string, ontologyId: string, input: Pick<OntologyRelation, 'name' | 'description' | 'sourceClassId' | 'targetClassId' | 'cardinality'>, credentials?: AuthCredentials) {
  return readJson<OntologyRelation>(await fetch(`${endpoint(projectId)}/${ontologyId}/relations`, { method: 'POST', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify(input) }))
}

export async function listOntologyReleases(projectId: string, ontologyId: string, credentials?: AuthCredentials) {
  return readJson<OntologyRelease[]>(await fetch(`${endpoint(projectId)}/${ontologyId}/releases`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function releaseOntology(projectId: string, ontologyId: string, version: string, credentials?: AuthCredentials, notes?: string) {
  return readJson<OntologyRelease>(await fetch(`${endpoint(projectId)}/${ontologyId}/releases`, { method: 'POST', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify({ version, notes: notes || undefined }) }))
}
