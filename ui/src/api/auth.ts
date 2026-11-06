export interface AuthCredentials {
  username: string
  password: string
}

export interface CurrentUser {
  username: string
  roles: string[]
}

const apiOrigin = (import.meta.env.VITE_ENTLOOM_API_BASE_URL ?? '').replace(/\/$/, '')
const currentUserEndpoint = `${apiOrigin}/api/v1/auth/me`

function basicAuthHeader(credentials: AuthCredentials) {
  return `Basic ${btoa(`${credentials.username}:${credentials.password}`)}`
}

export async function getCurrentUser(credentials: AuthCredentials): Promise<CurrentUser> {
  const response = await fetch(currentUserEndpoint, {
    method: 'GET',
    headers: {
      Accept: 'application/json',
      Authorization: basicAuthHeader(credentials),
    },
  })

  if (response.status === 401) {
    throw new Error('Invalid credentials')
  }

  if (!response.ok) {
    throw new Error(`Unable to authenticate (status ${response.status})`)
  }

  return response.json() as Promise<CurrentUser>
}

export function authorizationHeader(credentials: AuthCredentials) {
  return basicAuthHeader(credentials)
}
