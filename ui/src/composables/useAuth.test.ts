import { beforeEach, describe, expect, it, vi } from 'vitest'
import { getCurrentUser } from '../api/auth'
import { useAuth } from './useAuth'

vi.mock('../api/auth', () => ({
  getCurrentUser: vi.fn(),
}))

const mockedGetCurrentUser = vi.mocked(getCurrentUser)

describe('useAuth', () => {
  beforeEach(() => {
    vi.clearAllMocks()
  })

  it('stores credentials after a successful login', async () => {
    mockedGetCurrentUser.mockResolvedValue({ username: 'entloom', roles: ['ROLE_ADMIN'] })
    const auth = useAuth()

    await expect(auth.login('entloom', 'change-me')).resolves.toBe(true)

    expect(auth.user.value?.username).toBe('entloom')
    expect(auth.credentials.value).toEqual({ username: 'entloom', password: 'change-me' })
    expect(auth.error.value).toBe('')
  })

  it('clears credentials after a failed login', async () => {
    mockedGetCurrentUser.mockRejectedValue(new Error('Invalid credentials'))
    const auth = useAuth()

    await expect(auth.login('wrong', 'wrong')).resolves.toBe(false)

    expect(auth.user.value).toBeNull()
    expect(auth.credentials.value).toBeNull()
    expect(auth.error.value).toBe('Invalid credentials')
  })

  it('logs out locally', async () => {
    mockedGetCurrentUser.mockResolvedValue({ username: 'entloom', roles: ['ROLE_ADMIN'] })
    const auth = useAuth()
    await auth.login('entloom', 'change-me')

    auth.logout()

    expect(auth.user.value).toBeNull()
    expect(auth.credentials.value).toBeNull()
  })
})
