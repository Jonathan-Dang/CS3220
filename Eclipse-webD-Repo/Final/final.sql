	
	drop table if exists BEntries;
	drop table if exists Users;
	
	create table Users (
		id					integer primary key auto_increment,
		name				varchar(255) not null
	);
	
	create table BEntries(
		id					int primary key auto_increment,
		userId				int not null,
		SystoicVal			int not null,
		DiastolicVal		int not null,
		entryTime			datetime,
		FOREIGN KEY (userId) REFERENCES Users(id)
	);
	
	insert into Users(name) values ("Mom");
	insert into Users(name) values ("Dad");
		
		
	insert into BEntries(userId,SystoicVal,DiastolicVal, entryTime) values (1,110, 90, "2013-03-16 21:01:00");
	insert into BEntries(userId,SystoicVal,DiastolicVal, entryTime) values (1,185, 115, "2013-03-15 20:05:00");
	insert into BEntries(userId,SystoicVal,DiastolicVal, entryTime) values (1, 115, 95, "2013-03-14 20:15:00");
	
	
	insert into BEntries(userId,SystoicVal,DiastolicVal, entryTime) values (2, 115, 95, "2013-03-14 20:15:00");
	insert into BEntries(userId,SystoicVal,DiastolicVal, entryTime) values (2, 115, 95, "2013-03-14 20:15:00");
	insert into BEntries(userId,SystoicVal,DiastolicVal, entryTime) values (2, 115, 95, "2013-03-14 20:15:00");