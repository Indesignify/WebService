SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

CREATE SCHEMA IF NOT EXISTS test;

ALTER SCHEMA test OWNER TO postgres;

COMMENT ON SCHEMA test IS 'test schema';

SET search_path = test, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

DROP TABLE IF EXISTS person;

CREATE TABLE person (
    id SERIAL,
    last_name text,
    first_name text,
    middle_name text,
    birth_date date,
    comment text,
    update_date timestamp
);


ALTER TABLE test.person OWNER TO postgres;


COMMENT ON TABLE person IS 'person table';

COMMENT ON COLUMN person.id IS 'person id';

COMMENT ON COLUMN person.last_name IS 'person last name';

COMMENT ON COLUMN person.first_name IS 'person first name';

COMMENT ON COLUMN person.middle_name IS 'person middle name';

COMMENT ON COLUMN person.birth_date IS 'person birth date';

-- ALTER TABLE ONLY person
--     ADD CONSTRAINT person_pkey PRIMARY KEY (id);