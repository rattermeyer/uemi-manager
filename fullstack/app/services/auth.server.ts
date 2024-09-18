import {Authenticator} from 'remix-auth'
import {commitSession, getSession, sessionStorage} from './session.server'
import {redirect} from '@remix-run/node';

// define the user model
export type User = {
  username: string
  password: string
}

export const authenticator = new Authenticator<User>(sessionStorage)

export async function requireUserSession(request: Request) {
  // get the session
  const cookie = request.headers.get('cookie')
  const session = await getSession(cookie)
  // validate the session, `userId` is just an example, use whatever value you
  // put in the session when the user authenticated
  if (!session.has(authenticator.sessionKey)) {
    // if there is no user session, redirect to login
    session.flash('targetURL', request.url)
    throw redirect('/login', { headers: { 'Set-Cookie': await commitSession(session) } })
  }

  return session
}

