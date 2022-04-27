drop table if exists shop;


create table if not exists shop (
    identifier  int  IDENTITY  primary key ,
    name       varchar(50) not null ,
    price      int
);

