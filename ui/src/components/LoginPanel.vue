<script setup lang="ts">
import { ref } from 'vue'

defineProps<{
  loading: boolean
  error: string
}>()

const emit = defineEmits<{
  submit: [username: string, password: string]
}>()

const username = ref('')
const password = ref('')

function submit() {
  if (!username.value.trim() || !password.value) {
    return
  }
  emit('submit', username.value.trim(), password.value)
}
</script>

<template>
  <main class="auth-shell">
    <section class="auth-card">
      <div class="brand auth-brand">
        <div class="brand-mark">E</div>
        <div>
          <strong>Entloom</strong>
          <span>Open platform</span>
        </div>
      </div>
      <span class="eyebrow">Local platform access</span>
      <h1>Sign in to your workspace.</h1>
      <p>Use the server credentials configured for this Entloom environment.</p>
      <form @submit.prevent="submit">
        <label>
          Username
          <input v-model="username" autocomplete="username" required placeholder="entloom" />
        </label>
        <label>
          Password
          <input v-model="password" autocomplete="current-password" required type="password" placeholder="••••••••" />
        </label>
        <p v-if="error" class="state-message error-message" role="alert">{{ error }}</p>
        <button class="primary auth-submit" type="submit" :disabled="loading || !username.trim() || !password">
          {{ loading ? 'Signing in…' : 'Sign in' }}
        </button>
      </form>
    </section>
  </main>
</template>
