--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2014-09-19 16:52:53 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 16385)
-- Name: test; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA test;


ALTER SCHEMA test OWNER TO postgres;

--
-- TOC entry 1973 (class 0 OID 0)
-- Dependencies: 7
-- Name: SCHEMA test; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA test IS 'test schema';


SET search_path = test, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 16386)
-- Name: person; Type: TABLE; Schema: test; Owner: postgres; Tablespace: 
--

CREATE TABLE person (
    id integer NOT NULL,
    last_name text,
    first_name text,
    middle_name text,	
    birth_date date,
    comment text,
    update_date timestamp	
);


ALTER TABLE test.person OWNER TO postgres;

--
-- TOC entry 1974 (class 0 OID 0)
-- Dependencies: 171
-- Name: TABLE person; Type: COMMENT; Schema: test; Owner: postgres
--

COMMENT ON TABLE person IS 'person table';


--
-- TOC entry 1975 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN person.id; Type: COMMENT; Schema: test; Owner: postgres
--

COMMENT ON COLUMN person.id IS 'person id';


--
-- TOC entry 1976 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN person.last_name; Type: COMMENT; Schema: test; Owner: postgres
--

COMMENT ON COLUMN person.last_name IS 'person last name';


--
-- TOC entry 1977 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN person.first_name; Type: COMMENT; Schema: test; Owner: postgres
--

COMMENT ON COLUMN person.first_name IS 'person first name';


--
-- TOC entry 1978 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN person.middle_name; Type: COMMENT; Schema: test; Owner: postgres
--

COMMENT ON COLUMN person.middle_name IS 'person middle name';


--
-- TOC entry 1979 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN person.birth_date; Type: COMMENT; Schema: test; Owner: postgres
--

COMMENT ON COLUMN person.birth_date IS 'person birth date';


--
-- TOC entry 1968 (class 0 OID 16386)
-- Dependencies: 171
-- Data for Name: person; Type: TABLE DATA; Schema: test; Owner: postgres
--

INSERT INTO person (id, last_name, first_name, middle_name, birth_date) VALUES (1, 'Иванов', 'Иван', 'Иванович', '1985-05-06');
INSERT INTO person (id, last_name, first_name, middle_name, birth_date) VALUES (2, 'Петров', 'Петр', 'Петрович', '1990-12-08');


--
-- TOC entry 1860 (class 2606 OID 16393)
-- Name: person_pkey; Type: CONSTRAINT; Schema: test; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


-- Completed on 2014-09-19 16:52:53 MSK

--
-- PostgreSQL database dump complete
--

