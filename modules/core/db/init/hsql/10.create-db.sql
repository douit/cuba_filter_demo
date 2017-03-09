-- begin CUBAFILTERDEMO_PATIENT
create table CUBAFILTERDEMO_PATIENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DIAGNOSIS_ID integer,
    SIBLING_ID varchar(36),
    --
    primary key (ID)
)^
-- end CUBAFILTERDEMO_PATIENT
-- begin CUBAFILTERDEMO_DIAGNOSIS
create table CUBAFILTERDEMO_DIAGNOSIS (
    ID integer not null,
    UUID varchar(36),
    --
    LABEL varchar(255) not null,
    PARENT_ID integer,
    --
    primary key (ID)
)^
-- end CUBAFILTERDEMO_DIAGNOSIS
-- begin CUBAFILTERDEMO_SIBLING
create table CUBAFILTERDEMO_SIBLING (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DIAGNOSIS_ID integer,
    --
    primary key (ID)
)^
-- end CUBAFILTERDEMO_SIBLING
