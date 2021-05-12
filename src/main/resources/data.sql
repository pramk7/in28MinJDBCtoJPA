create table person(
id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id)
);

insert into person values(10001,'parshuram','pune',sysdate());
insert into person values(10002,'Radha','pune',sysdate());
insert into person values(10003,'Ram','majalgaon',sysdate());
insert into person values(10004,'Jay','Aurangabad',sysdate());