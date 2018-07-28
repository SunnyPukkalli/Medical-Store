create table medicine_users(
user_id serial,
username varchar not null,
password varchar not null);

CREATE TABLE medicine_user_roles
(
  medicine_role_id integer NOT NULL,
  username character varying,
  medicine_user_role character varying
);