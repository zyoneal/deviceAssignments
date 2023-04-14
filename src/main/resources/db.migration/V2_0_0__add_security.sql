alter table employees add column email text;

alter table employees add column password text;

alter table employees add column role text;

CREATE TABLE token (
  id int4 NOT NULL,
  expired boolean NOT NULL,
  revoked boolean NOT NULL,
  token varchar(255) NULL,
  token_type varchar(255) NULL,
  employee_id int8 NULL,
  CONSTRAINT token_pkey PRIMARY KEY (id),
  CONSTRAINT uk_token UNIQUE (token)
);

ALTER TABLE token ADD CONSTRAINT token_employee_id_fk FOREIGN KEY (employee_id) REFERENCES employees(id);

CREATE SEQUENCE public.token_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
