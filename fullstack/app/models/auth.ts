import {z} from 'zod';
import {zodResolver} from '@hookform/resolvers/zod';

export type UserProfile = {
  id: string
  displayName: string
  email: string
  roles: string[]
}

export const user = z.object({
  email: z.string().email(),
  password: z.string().min(2),
});

export type User = z.infer<typeof user>;

export const userResolver = zodResolver(user);
