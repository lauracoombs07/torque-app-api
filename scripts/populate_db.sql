truncate table member;
truncate table team cascade;

insert into team
    (pk_id,                                  team_name,              team_description,                          ui_release_date, api_release_date,    ui_app_version, api_app_version)
values
    ('a1d05959-5da6-40ae-b3b8-e72f8f81e4f7', 'Personnel Management', 'Track user schedules and certifications', '2024-03-01',       '2024-03-01',           '3.1.4', '3.1.4'),
    ('c113d3c5-0aa0-475c-8182-5544fa98b402', 'Fleet Management',     'Add and manage Organizations or Units',   '2024-01-01',       '2024-01-01',           '2.3.0', '2.3.0'),
    ('003c00a6-cc50-449f-8311-5f850126f397', 'Aircraft Schedule',    'Schedule Aircraft Maintenance',           '2024-01-01',       '2024-01-01',           '1.4.0', '1.4.0'),
    ('2f8fbb13-034c-4ead-803a-1191a51f9aea', 'Depot Performance',    'Depot stuff',                             '2024-01-01',       '2024-01-01',           '2.1.0', '2.1.0'),
    ('42fd7663-d571-4ff1-8a5f-081ebaf8e70d', 'Access Control',       'Add, manage and remove user access',      '2024-01-01',       '2024-01-01',           '3.5.1', '3.5.1'),
    ('7611d4cd-dfb8-4b38-bf1f-f3e46ab69f27', 'Portfolio',            'Portfolio',                               '2024-03-01',       '2024-03-01',           '1.5.1', '1.5.1')
on conflict do nothing;
DO $$
    DECLARE
        DEVELOPER UUID := (select pk_id from role where role_name = 'Developer');
        ANCHOR UUID := (select pk_id from role where role_name = 'Anchor');
        ENGINEERING_LEAD UUID := (select pk_id from role where role_name = 'Engineering Lead');

    BEGIN
insert into member
    (pk_id,                                  first_name, last_name,     fk_role_id,               email,                  fk_team_id                              )
values
    ('a1d05959-5da6-40ae-b3b8-e72f8f81e4f7', 'Laura',    'Coombs',      DEVELOPER,        'lcoombs@kr.af.mil',    'a1d05959-5da6-40ae-b3b8-e72f8f81e4f7'),
    ('af8d5cc5-1385-4f0a-95a4-086aec18cdbe', 'Austin',   'Stephens',    ANCHOR,           'astephens@kr.af.mil',  'a1d05959-5da6-40ae-b3b8-e72f8f81e4f7'),
    ('f6c8aff3-0cd3-4929-852c-672ef5effd99', 'Craig',    'Blanch',      ENGINEERING_LEAD, 'cblanch@kr.af.mil',    '7611d4cd-dfb8-4b38-bf1f-f3e46ab69f27'),
    ('c6ac9cd7-c816-4b9d-8c2d-337f8e5aeaf9', 'Jake',     'Afuvai',      ANCHOR,           'jafuvai@kr.af.mil',    '42fd7663-d571-4ff1-8a5f-081ebaf8e70d'),
    ('5f6e483f-2523-4334-8808-b32c1a6cccd5', 'Brody',    'Prestwich',   ANCHOR,           'bprestwich@kr.af.mil', '003c00a6-cc50-449f-8311-5f850126f397')
on conflict do nothing;

END $$;
