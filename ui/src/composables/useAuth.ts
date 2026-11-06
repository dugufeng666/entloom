import { ref } from 'vue'
import { getCurrentUser, type AuthCredentials, type CurrentUser } from '../api/auth'

export function useAuth() {
  const credentials = ref<AuthCredentials | null>(null)
  const user = ref<CurrentUser | null>(null)
  const loading = ref(false)
  const error = ref('')

  async function login(username: string, password: string) {
    loading.value = true
    error.value = ''
    credentials.value = null
    user.value = null
    try {
      const nextCredentials = { username: username.trim(), password }
      user.value = await getCurrentUser(nextCredentials)
      credentials.value = nextCredentials
      return true
    } catch (cause) {
      error.value = cause instanceof Error ? cause.message : 'Unable to authenticate'
      return false
    } finally {
      loading.value = false
    }
  }

  function logout() {
    credentials.value = null
    user.value = null
    error.value = ''
  }

  return {
    credentials,
    user,
    loading,
    error,
    login,
    logout,
  }
}
