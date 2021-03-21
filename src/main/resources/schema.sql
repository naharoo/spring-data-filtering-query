create table if not exists course
(
    id bigserial not null primary key
);

create table if not exists applicant
(
    id           bigserial not null primary key,
    name         varchar   not null,
    email        varchar   not null unique,
    phone_number varchar   not null,
    address      varchar   not null,
    course_id    bigint    not null references course (id)
);
