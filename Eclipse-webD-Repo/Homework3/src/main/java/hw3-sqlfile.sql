drop table if exists Patients;
drop table if exists Vaccines;

create table Vaccines(
	id				integer auto_increment primary key,
	name			varchar(255) not null,
	doses_required	integer not null,
	days_between	integer not null,
	doses_remaining	integer not null,
	total_doses		integer not null
);

insert into Vaccines(name, doses_required, days_between, doses_remaining, total_doses) values ("Pfizer/BioTech", 2,21,9998,10000);
insert into Vaccines(name, doses_required, days_between, doses_remaining, total_doses) values ("Johnson & Johnson", 1, 0, 4999, 5000);
insert into Vaccines(name, doses_required, days_between, doses_remaining, total_doses) values ("Moderna", 2, 24, 0, 1);


create table Patients(
	id				int auto_increment primary key,
	name			varchar(255) not null,
	first_dose		date not null,
	second_dose		date,
	vaccine_id		int not null,
	FOREIGN KEY (vaccine_id) REFERENCES Vaccines(id)
);

insert into Patients(name, first_dose, second_dose, vaccine_id) values ("John Doe", DATE("2021-2-12"), DATE("2021-3-11"), 1);
insert into Patients(name, first_dose, second_dose, vaccine_id) values ("Jane Doe", DATE("2021-2-18"), null, 1);
insert into Patients(name, first_dose, second_dose, vaccine_id) values ("Tom Smith", DATE("2021-3-12"), null, 2);
insert into Patients(name, first_dose, second_dose, vaccine_id) values ("Jim Lee", DATE("2021-3-12"), null, 3);

