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
    idlog integer NOT NULL,
    newtime timestamp without time zone NOT NULL
);
CREATE TABLE logCC (
    "id" SERIAL NOT NULL PRIMARY KEY,
    "timestamp" timestamp without time zone NOT NULL,
    "id_employee" integer NOT NULL,
	"device" integer not null
);

CREATE TABLE employee(
    "id" integer primary key NOT NULL,
    "name" varchar (50) NOT NULL,
    "birthDate" date NOT NULL,
    "Unit" integer NOT NULL,
    "role" integer NOT NULL,
	"gender" integer Not NULL
);

insert into employee values(20205105,'Nguyen Van Nam','01-05-2002',2,1,1);
insert into users(id,password) values(20205103,'nam');
insert into users values(20205104,'123456');
insert into users values(20205105,'man');
insert into employee values(20204939,'Nguyễn Cơ Tuấn Anh','10-27-2002',2,3,1);
insert into users values(20204939,'11');

delete from logCC;
INSERT INTO logCC (timestamp, id_employee, device)
VALUES
    (TO_TIMESTAMP('2023-06-01 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-01 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-02 08:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-02 14:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-03 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-03 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-04 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-04 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-05 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-05 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-06 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-06 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-07 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-07 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-08 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-08 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-09 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-09 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-10 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-10 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-11 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-11 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-12 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-12 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-13 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-13 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-14 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-14 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-15 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-15 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-16 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-16 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-17 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-17 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-18 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-18 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-19 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-19 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-20 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-20 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-21 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-21 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-22 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-22 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-23 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-23 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-24 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-24 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-25 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-25 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-26 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-26 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-27 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-27 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-28 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-28 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-29 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-29 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0),
    (TO_TIMESTAMP('2023-06-30 07:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,1),
    (TO_TIMESTAMP('2023-06-30 17:34:56', 'YYYY-MM-DD HH24:MI:SS'),20204939,0)


