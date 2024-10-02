import {Text, Box, Group, Collapse, UnstyledButton, ThemeIcon, rem} from '@mantine/core';
import { useState } from 'react';
import classes from './navbar-links-group.module.css';
import { IconChevronRight } from '@tabler/icons-react';
import { NavLink } from '@remix-run/react';


interface LinksGroupProps {
    icon: React.FC<any>;
    label: string;
    initiallyOpened?: boolean;
    link?: string;
    links?: { label: string; link: string }[];
  }
export function LinksGroup({icon: Icon, label, initiallyOpened, link, links}: LinksGroupProps) {
    const hasLinks = Array.isArray(links);
    const [opened, setOpened] = useState(initiallyOpened || false);
    const items = (hasLinks ? links : []).map((link) => (
        <NavLink
            className={classes.link}
            to={link.link}
            key={link.label}
        >
            {link.label}
        </NavLink>
    ));

    return (
        <>
            <UnstyledButton onClick={() => setOpened((o) => !o)} className={classes.control}>
                <Group justify="space-between" gap={0}>
                    <Box style={{display: 'flex', alignItems: 'center'}}>
                        <ThemeIcon variant="light" size={30}>
                            <Icon style={{width: rem(18), height: rem(18)}}/>
                        </ThemeIcon>
                        <Box ml="md">
                            {hasLinks && label}
                            {!hasLinks && <NavLink className={classes.firstLevelLink} to={link}>{label}</NavLink>}
                        </Box>
                    </Box>
                    {hasLinks && (
                        <IconChevronRight
                            className={classes.chevron}
                            stroke={1.5}
                            style={{
                                width: rem(16),
                                height: rem(16),
                                transform: opened ? 'rotate(-90deg)' : 'none',
                            }}
                        />
                    )}
                </Group>
            </UnstyledButton>
            {hasLinks ? <Collapse in={opened}>{items}</Collapse> : null}
        </>
    );
}
