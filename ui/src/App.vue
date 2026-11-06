<script setup lang="ts">
import { computed, ref } from 'vue'

const activeModule = ref('Overview')
const modules = ['Overview', 'Projects', 'Ontology', 'Datasets', 'Validation', 'Queries']

const activeDescription = computed(() => {
  if (activeModule.value === 'Overview') return 'A stable foundation for enterprise ontology and agent projects.'
  return `${activeModule.value} workspace is being built from the public API contract.`
})
</script>

<template>
  <div class="shell">
    <aside class="sidebar">
      <div class="brand">
        <div class="brand-mark">E</div>
        <div>
          <strong>Entloom</strong>
          <span>Open platform</span>
        </div>
      </div>

      <nav class="nav" aria-label="Platform modules">
        <button
          v-for="module in modules"
          :key="module"
          class="nav-item"
          :class="{ active: activeModule === module }"
          type="button"
          @click="activeModule = module"
        >
          <span class="nav-dot" />
          {{ module }}
        </button>
      </nav>

      <div class="sidebar-footer">
        <span class="status-dot" />
        API contract v1
      </div>
    </aside>

    <main class="main">
      <header class="topbar">
        <div>
          <span class="eyebrow">Enterprise ontology & agents</span>
          <h1>{{ activeModule }}</h1>
        </div>
        <a class="github-link" href="https://github.com/dugufeng666/entloom" target="_blank" rel="noreferrer">
          GitHub ↗
        </a>
      </header>

      <section class="hero-card">
        <div>
          <span class="pill">Public foundation · v0.1</span>
          <h2>Make the business model explicit.</h2>
          <p>{{ activeDescription }}</p>
          <div class="hero-actions">
            <button class="primary" type="button" @click="activeModule = 'Projects'">Open workspace</button>
            <a class="secondary" href="https://github.com/dugufeng666/entloom/tree/main/server" target="_blank" rel="noreferrer">View server API</a>
          </div>
        </div>
        <div class="graph-preview" aria-label="Ontology graph preview" role="img">
          <span class="line line-a" />
          <span class="line line-b" />
          <span class="line line-c" />
          <span class="node node-a">Company</span>
          <span class="node node-b">Capability</span>
          <span class="node node-c">Agent</span>
          <span class="node node-d">Evidence</span>
        </div>
      </section>

      <section class="metric-grid" aria-label="Platform foundation metrics">
        <article class="metric-card">
          <span class="metric-label">Model status</span>
          <strong>Draft</strong>
          <span class="metric-note">Versioned changes are planned.</span>
        </article>
        <article class="metric-card">
          <span class="metric-label">API</span>
          <strong>Ready</strong>
          <span class="metric-note">Spring Boot 4.1.2 baseline.</span>
        </article>
        <article class="metric-card">
          <span class="metric-label">Community</span>
          <strong>Open</strong>
          <span class="metric-note">Issues and pull requests welcome.</span>
        </article>
      </section>
    </main>
  </div>
</template>
