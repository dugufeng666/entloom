import { authorizationHeader, type AuthCredentials } from './auth'

export type OntologyStatus = 'DRAFT' | 'RELEASED' | 'ARCHIVED'
export interface Ontology { id: string; projectId: string; name: string; description?: string | null; status: OntologyStatus; requireClassProperties?: boolean; allowSelfRelations?: boolean }
export interface OntologyClass { id: string; ontologyId: string; name: string; description?: string | null }
export type OntologyPropertyValueType = 'TEXT' | 'NUMBER' | 'BOOLEAN' | 'DATE' | 'REFERENCE'
export type OntologyRelationCardinality = 'ONE_TO_ONE' | 'ONE_TO_MANY' | 'MANY_TO_ONE' | 'MANY_TO_MANY'
export interface OntologyProperty { id: string; ontologyId: string; classId: string; name: string; description?: string | null; valueType: OntologyPropertyValueType; required: boolean }
export interface OntologyRelation { id: string; ontologyId: string; sourceClassId: string; targetClassId: string; name: string; description?: string | null; cardinality: OntologyRelationCardinality }
export interface OntologyRelease { id: string; ontologyId: string; version: string; notes?: string | null; releasedBy?: string; releasedAt?: string; classCount: number; propertyCount: number; relationCount: number }
export type OntologyChangeType = 'ADDED' | 'MODIFIED' | 'DELETED'
export interface OntologyReleaseChange { kind: 'CLASS' | 'PROPERTY' | 'RELATION'; changeType: OntologyChangeType; itemId: string; name: string; location: string; before?: unknown; after?: unknown }
export interface OntologyReleaseDiff { fromReleaseId: string; fromVersion: string; toReleaseId: string; toVersion: string; changes: OntologyReleaseChange[] }
export interface OntologyValidationIssue { severity: 'ERROR' | 'WARNING'; code: string; message: string; location: string }
export interface OntologyValidation { valid: boolean; issues: OntologyValidationIssue[] }
export interface OntologyLayoutPosition { x: number; y: number }
export interface OntologyLayout { positions: Record<string, OntologyLayoutPosition> }

const apiOrigin = (import.meta.env.VITE_ENTLOOM_API_BASE_URL ?? '').replace(/\/$/, '')
const endpoint = (projectId: string) => `${apiOrigin}/api/v1/projects/${projectId}/ontologies`

async function readJson<T>(response: Response): Promise<T> {
  if (!response.ok) throw new Error((await response.text()) || `Entloom API request failed with status ${response.status}`)
  return response.json() as Promise<T>
}

async function deleteResource(url: string, credentials?: AuthCredentials) {
  const response = await fetch(url, { method: 'DELETE', headers: { Accept: 'application/json', ...authHeaders(credentials) } })
  if (!response.ok) throw new Error((await response.text()) || `Entloom API request failed with status ${response.status}`)
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

export async function updateOntology(projectId: string, ontologyId: string, input: { name: string; description: string; requireClassProperties?: boolean; allowSelfRelations?: boolean }, credentials?: AuthCredentials) {
  return readJson<Ontology>(await fetch(`${endpoint(projectId)}/${ontologyId}`, { method: 'PATCH', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify(input) }))
}

export async function listOntologyClasses(projectId: string, ontologyId: string, credentials?: AuthCredentials) {
  return readJson<OntologyClass[]>(await fetch(`${endpoint(projectId)}/${ontologyId}/classes`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function createOntologyClass(projectId: string, ontologyId: string, name: string, description: string, credentials?: AuthCredentials) {
  return readJson<OntologyClass>(await fetch(`${endpoint(projectId)}/${ontologyId}/classes`, { method: 'POST', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify({ name, description }) }))
}

export async function changeOntologyStatus(projectId: string, ontologyId: string, status: OntologyStatus, credentials?: AuthCredentials) {
  return readJson<Ontology>(await fetch(`${endpoint(projectId)}/${ontologyId}/status`, { method: 'PATCH', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify({ status }) }))
}

export async function forkOntology(projectId: string, ontologyId: string, name: string, description: string, credentials?: AuthCredentials) {
  return readJson<Ontology>(await fetch(`${endpoint(projectId)}/${ontologyId}/fork`, { method: 'POST', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify({ name, description }) }))
}

export async function validateOntology(projectId: string, ontologyId: string, credentials?: AuthCredentials) {
  return readJson<OntologyValidation>(await fetch(`${endpoint(projectId)}/${ontologyId}/validation`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function getOntologyLayout(projectId: string, ontologyId: string, credentials?: AuthCredentials) {
  return readJson<OntologyLayout>(await fetch(`${endpoint(projectId)}/${ontologyId}/layout`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function saveOntologyLayout(projectId: string, ontologyId: string, positions: Record<string, OntologyLayoutPosition>, credentials?: AuthCredentials) {
  return readJson<OntologyLayout>(await fetch(`${endpoint(projectId)}/${ontologyId}/layout`, { method: 'PATCH', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify({ positions }) }))
}

export async function deleteOntologyClass(projectId: string, ontologyId: string, classId: string, credentials?: AuthCredentials) { return deleteResource(`${endpoint(projectId)}/${ontologyId}/classes/${classId}`, credentials) }

export async function listOntologyProperties(projectId: string, ontologyId: string, classId: string, credentials?: AuthCredentials) {
  return readJson<OntologyProperty[]>(await fetch(`${endpoint(projectId)}/${ontologyId}/classes/${classId}/properties`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function createOntologyProperty(projectId: string, ontologyId: string, classId: string, input: Pick<OntologyProperty, 'name' | 'description' | 'valueType' | 'required'>, credentials?: AuthCredentials) {
  return readJson<OntologyProperty>(await fetch(`${endpoint(projectId)}/${ontologyId}/classes/${classId}/properties`, { method: 'POST', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify(input) }))
}

export async function updateOntologyProperty(projectId: string, ontologyId: string, classId: string, propertyId: string, input: Pick<OntologyProperty, 'name' | 'description' | 'valueType' | 'required'>, credentials?: AuthCredentials) {
  return readJson<OntologyProperty>(await fetch(`${endpoint(projectId)}/${ontologyId}/classes/${classId}/properties/${propertyId}`, { method: 'PATCH', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify(input) }))
}

export async function deleteOntologyProperty(projectId: string, ontologyId: string, classId: string, propertyId: string, credentials?: AuthCredentials) { return deleteResource(`${endpoint(projectId)}/${ontologyId}/classes/${classId}/properties/${propertyId}`, credentials) }

export async function listOntologyRelations(projectId: string, ontologyId: string, credentials?: AuthCredentials) {
  return readJson<OntologyRelation[]>(await fetch(`${endpoint(projectId)}/${ontologyId}/relations`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function createOntologyRelation(projectId: string, ontologyId: string, input: Pick<OntologyRelation, 'name' | 'description' | 'sourceClassId' | 'targetClassId' | 'cardinality'>, credentials?: AuthCredentials) {
  return readJson<OntologyRelation>(await fetch(`${endpoint(projectId)}/${ontologyId}/relations`, { method: 'POST', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify(input) }))
}

export async function updateOntologyRelation(projectId: string, ontologyId: string, relationId: string, input: Pick<OntologyRelation, 'name' | 'description' | 'sourceClassId' | 'targetClassId' | 'cardinality'>, credentials?: AuthCredentials) {
  return readJson<OntologyRelation>(await fetch(`${endpoint(projectId)}/${ontologyId}/relations/${relationId}`, { method: 'PATCH', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify(input) }))
}

export async function deleteOntologyRelation(projectId: string, ontologyId: string, relationId: string, credentials?: AuthCredentials) { return deleteResource(`${endpoint(projectId)}/${ontologyId}/relations/${relationId}`, credentials) }

export async function listOntologyReleases(projectId: string, ontologyId: string, credentials?: AuthCredentials) {
  return readJson<OntologyRelease[]>(await fetch(`${endpoint(projectId)}/${ontologyId}/releases`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function compareOntologyReleases(projectId: string, ontologyId: string, from: string, to: string, credentials?: AuthCredentials) {
  const query = new URLSearchParams({ from, to })
  return readJson<OntologyReleaseDiff>(await fetch(`${endpoint(projectId)}/${ontologyId}/releases/diff?${query}`, { headers: { Accept: 'application/json', ...authHeaders(credentials) } }))
}

export async function releaseOntology(projectId: string, ontologyId: string, version: string, credentials?: AuthCredentials, notes?: string) {
  return readJson<OntologyRelease>(await fetch(`${endpoint(projectId)}/${ontologyId}/releases`, { method: 'POST', headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...authHeaders(credentials) }, body: JSON.stringify({ version, notes: notes || undefined }) }))
}
