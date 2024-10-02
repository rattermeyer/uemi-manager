// app/routes/login.tsx
import {Anchor, Button, Checkbox, Container, Group, Paper, PasswordInput, Text, TextInput, Title} from "@mantine/core";
import type {ActionFunction} from "@remix-run/node";
import classes from "~/css/Login.module.css";
import {Form, useSearchParams} from "@remix-run/react";
import {useRemixForm} from "remix-hook-form";
import {type User, userResolver} from '~/models/auth';
import {authenticator} from '~/services/auth.server';


export const loader = async () => {
    return null;
};

export const action: ActionFunction = async ({request, context}) => {
    return await authenticator.authenticate("form", request, {
        successRedirect: "/protected",
        failureRedirect: "/login?loginFailed=true",
    });
};

export default function Login() {
    const [searchParams] = useSearchParams();
    const {
        formState: {errors},
        handleSubmit,
        register,
    } = useRemixForm<User>({
        resolver: userResolver,
    });
    return (
        <Container size={420} my={40}>
            <Title ta="center" className={classes.title}>
                Welcome back!
            </Title>

            <Paper withBorder shadow="md" p={30} mt={30} radius="md">
                {errors.root && <div>{errors.root.message}</div>}
                {searchParams.get("loginFailed") && (
                    <Text c="red" ta="center">
                        Invalid email or password
                    </Text>
                )}
                <Form method="post" onSubmit={handleSubmit}>
                    <TextInput
                        label="Email"
                        placeholder="you@mantine.dev"
                        {...register("email")}
                        error={errors.email?.message}
                    />
                    <PasswordInput
                        label="Password"
                        placeholder="Your password"
                        mt="md"
                        {...register("password")}
                        error={errors.password?.message}
                    />
                    <Group justify="space-between" mt="lg">
                        <Checkbox label="Remember me"/>
                        <Anchor component="button" size="sm">
                            Forgot password?
                        </Anchor>
                    </Group>
                    <Button type={"submit"} fullWidth mt="xl">
                        Sign in
                    </Button>
                </Form>
            </Paper>
        </Container>
    );
}
