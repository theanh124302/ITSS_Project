CREATE DATABASE "ITSS_project"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
create table users(
	id integer primary key,
	password VARCHAR ( 50 ) NOT NULL
);
CREATE TABLE form (
    idform integer NOT NULL primary key,
    idnhanvien integer NOT NULL,
    status boolean NOT NULL,
    oldtime timestamp without time zone NOT NULL,
    newtime timestamp with time zone NOT NULL
);
CREATE TABLE logCC (
    "timestamp" timestamp without time zone NOT NULL,
    "id" integer NOT NULL, 
	"device" integer not null 
);
CREATE TABLE employee(
    "id" integer primary key NOT NULL,
    "name" varchar (50) NOT NULL,
    "birthDate" date NOT NULL,
    "Unit" integer NOT NULL,
    "role" integer NOT NULL
);