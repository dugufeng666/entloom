<script setup lang="ts">
import { computed, onMounted, ref } from 'vue'
import type { AuthCredentials } from '../api/auth'
import { createOntology, createOntologyClass, listOntologyClasses, listOntologies, releaseOntology, type Ontology, type OntologyClass } from '../api/ontology'
import { listProjects, type Project } from '../api/projects'

const props = defineProps<{ credentials: AuthCredentials | null }>()
const projects = ref<Project[]>([]); const ontologies = ref<Ontology[]>([]); const classes = ref<OntologyClass[]>([])
const projectId = ref(''); const ontologyId = ref(''); const ontologyName = ref(''); const className = ref(''); const message = ref(''); const error = ref(''); const loading = ref(false)
const selectedOntology = computed(() => ontologies.value.find(item => item.id === ontologyId.value))
const headersCredentials = () => props.credentials ?? undefined

async function loadProjects() { projects.value = await listProjects(headersCredentials()); if (!projectId.value && projects.value[0]) projectId.value = projects.value[0].id; await loadOntologies() }
async function loadOntologies() { if (!projectId.value) return; ontologies.value = await listOntologies(projectId.value, headersCredentials()); ontologyId.value = ontologies.value[0]?.id ?? ''; await loadClasses() }
async function loadClasses() { if (!projectId.value || !ontologyId.value) { classes.value = []; return }; classes.value = await listOntologyClasses(projectId.value, ontologyId.value, headersCredentials()) }
async function run(action: () => Promise<void>) { loading.value = true; error.value = ''; message.value = ''; try { await action() } catch (cause) { error.value = cause instanceof Error ? cause.message : 'Request failed' } finally { loading.value = false } }
async function submitOntology() { if (!projectId.value || !ontologyName.value.trim()) return; await run(async () => { const item = await createOntology(projectId.value, ontologyName.value.trim(), '', headersCredentials()); ontologyName.value = ''; await loadOntologies(); ontologyId.value = item.id; await loadClasses(); message.value = 'Ontology created' }) }
async function submitClass() { if (!projectId.value || !ontologyId.value || !className.value.trim()) return; await run(async () => { await createOntologyClass(projectId.value, ontologyId.value, className.value.trim(), '', headersCredentials()); className.value = ''; await loadClasses(); message.value = 'Class created' }) }
async function publish() { if (!projectId.value || !ontologyId.value) return; await run(async () => { await releaseOntology(projectId.value, ontologyId.value, '0.1.0', headersCredentials()); await loadOntologies(); message.value = 'Ontology released as 0.1.0' }) }
onMounted(() => run(loadProjects))
</script>

<template>
  <section class="workspace" aria-labelledby="ontology-heading">
    <div class="workspace-heading"><div><span class="eyebrow">Ontology studio</span><h2 id="ontology-heading">Model a business context</h2><p>Build a project-scoped ontology, add classes, then publish a versioned release.</p></div><span class="api-badge">API v1</span></div>
    <p v-if="error" class="state-message error-message">{{ error }}</p><p v-if="message" class="state-message">{{ message }}</p>
    <div class="ontology-toolbar"><label>Project<select v-model="projectId" @change="loadOntologies"><option v-for="project in projects" :key="project.id" :value="project.id">{{ project.name }}</option></select></label><label>Ontology<select v-model="ontologyId" @change="loadClasses"><option v-for="ontology in ontologies" :key="ontology.id" :value="ontology.id">{{ ontology.name }} · {{ ontology.status }}</option></select></label></div>
    <div class="workspace-grid">
      <form class="project-form" @submit.prevent="submitOntology"><span class="section-label">Ontology</span><h3>Create a model</h3><input v-model="ontologyName" required maxlength="120" placeholder="e.g. Customer context" /><button class="primary" :disabled="loading || !projectId || !ontologyName.trim()">Create ontology</button></form>
      <div class="project-list"><div class="list-heading"><div><span class="section-label">Classes</span><h3>{{ classes.length }} class<span v-if="classes.length !== 1">es</span></h3></div><button v-if="selectedOntology?.status === 'DRAFT'" class="quiet-button" type="button" :disabled="loading" @click="publish">Publish 0.1.0</button></div><form v-if="selectedOntology?.status === 'DRAFT'" class="inline-form" @submit.prevent="submitClass"><input v-model="className" required maxlength="120" placeholder="Add a class, e.g. Customer" /><button class="primary" :disabled="loading || !className.trim()">Add class</button></form><p v-if="!ontologyId" class="state-message">Create or select an ontology to start modeling.</p><ul v-else class="project-items"><li v-for="item in classes" :key="item.id" class="project-item"><div><strong>{{ item.name }}</strong><span>{{ item.description || 'Class definition' }}</span></div><span class="status-badge">CLASS</span></li></ul></div>
    </div>
  </section>
</template>
