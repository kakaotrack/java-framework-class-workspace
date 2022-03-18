create table userinfo
(
    id int auto_increment
        primary key,
    name varchar(32) null,
    password varchar(32) null,
);

insert into userinfo (name, password) values ( 'hulk',  '1234');

