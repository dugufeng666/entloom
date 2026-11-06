import { afterEach, describe, expect, it, vi } from 'vitest'
import { getCurrentUser, type AuthCredentials } from './auth'

describe('auth API client', () => {
  afterEach(() => vi.restoreAllMocks())

  it('requests the current user with HTTP Basic credentials', async () => {
    vi.stubGlobal('fetch', vi.fn().mockResolvedValue(
      new Response(JSON.stringify({ username: 'entloom', roles: ['ROLE_ADMIN'] }), {
        status: 200,
        headers: { 'Content-Type': 'application/json' },
      }),
    ))
    const credentials: AuthCredentials = { username: 'entloom', password: 'change-me' }

    await expect(getCurrentUser(credentials)).resolves.toEqual({
      username: 'entloom',
      roles: ['ROLE_ADMIN'],
    })
    expect(fetch).toHaveBeenCalledWith('/api/v1/auth/me', expect.objectContaining({
      headers: expect.objectContaining({
        Authorization: `Basic ${btoa('entloom:change-me')}`,
      }),
    }))
  })

  it('returns a readable error for invalid credentials', async () => {
    vi.stubGlobal('fetch', vi.fn().mockResolvedValue(
      new Response('', { status: 401, statusText: 'Unauthorized' }),
    ))

    await expect(getCurrentUser({ username: 'wrong', password: 'wrong' })).rejects.toThrow('Invalid credentials')
  })
})
