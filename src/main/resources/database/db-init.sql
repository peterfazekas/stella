create table stellauser(
    username varchar(255),
    fullname varchar(255),
    password varchar(500),
    primary key (username)
);
insert into stellauser(username, fullname, password) values ('fazek', 'Fazekas Péter', '1234');
