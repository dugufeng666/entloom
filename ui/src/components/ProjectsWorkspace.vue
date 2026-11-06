<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { useProjects } from '../composables/useProjects'

const projectName = ref('')
const projectDescription = ref('')
const { projects, loading, creating, error, load, create } = useProjects()

onMounted(load)

async function submit() {
  const name = projectName.value.trim()
  if (!name || creating.value) {
    return
  }

  const project = await create({
    name,
    description: projectDescription.value.trim(),
  })

  if (project) {
    projectName.value = ''
    projectDescription.value = ''
  }
}
</script>

<template>
  <section class="workspace" aria-labelledby="projects-heading">
    <div class="workspace-heading">
      <div>
        <span class="eyebrow">Context workspaces</span>
        <h2 id="projects-heading">Projects</h2>
        <p>Start with a bounded workspace for ontology, metadata and agent experiments.</p>
      </div>
      <button class="quiet-button" type="button" :disabled="loading" @click="load">
        {{ loading ? 'Refreshing…' : 'Refresh' }}
      </button>
    </div>

    <div class="workspace-grid">
      <form class="project-form" @submit.prevent="submit">
        <div>
          <span class="section-label">New project</span>
          <h3>Create a workspace</h3>
        </div>
        <label>
          Name
          <input v-model="projectName" required maxlength="120" placeholder="e.g. Customer ontology" />
        </label>
        <label>
          Description
          <textarea v-model="projectDescription" maxlength="1000" rows="4" placeholder="What will this project make explicit?" />
        </label>
        <button class="primary" type="submit" :disabled="creating || !projectName.trim()">
          {{ creating ? 'Creating…' : 'Create project' }}
        </button>
      </form>

      <div class="project-list" aria-live="polite" :aria-busy="loading">
        <div class="list-heading">
          <div>
            <span class="section-label">Workspace registry</span>
            <h3>{{ projects.length }} project<span v-if="projects.length !== 1">s</span></h3>
          </div>
          <span class="api-badge">API v1</span>
        </div>

        <p v-if="error" class="state-message error-message">{{ error }}</p>
        <p v-else-if="loading" class="state-message">Loading projects…</p>
        <p v-else-if="projects.length === 0" class="state-message">No projects yet. Create the first workspace.</p>
        <ul v-else class="project-items">
          <li v-for="project in projects" :key="project.id" class="project-item">
            <div>
              <strong>{{ project.name }}</strong>
              <span>{{ project.description || 'No description yet.' }}</span>
            </div>
            <span class="status-badge" :data-status="project.status">{{ project.status }}</span>
          </li>
        </ul>
      </div>
    </div>
  </section>
</template>
