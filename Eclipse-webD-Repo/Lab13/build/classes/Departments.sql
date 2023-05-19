drop table if exists departments;

create table departments(
	id				integer auto_increment primary key,
	name			varchar(255)
);

insert into departments (name) values ("Computer Science");
insert into departments (name) values ("Electrical and Computer Engineering");

drop table if exists faculty;

create table faculty(
	id				integer auto_increment primary key,
	name			varchar(255) not null,
	isChair			boolean default(false) not null,
	dept_id			integer not null,
	FOREIGN KEY (dept_id) REFERENCES departments(id)
);