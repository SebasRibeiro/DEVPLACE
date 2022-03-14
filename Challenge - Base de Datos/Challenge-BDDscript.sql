create database Challenge;
use Challenge;
create table empleado(
	idEmpleado int unsigned auto_increment,
    nombre varchar(45) not null,
    apellido varchar(45) not null,
    telefono varchar(35) not null,
    email varchar(45) unique not null,
    idPuestoLaboral int unsigned not null,
    idMucicipalidad int unsigned not null,
    
    constraint idEmpleado primary key(idEmpleado),
    constraint idPuestoLaboral foreign key(idPuestoLaboral) references puestoLaboral(idPuestoLaboral),
    constraint idMucicipalidad foreign key(idMucicipalidad) references mucicipalidad(idMucicipalidad)
);

create table puestoLaboral(
	idPuestoLaboral int unsigned auto_increment,
    nombre varchar(150) not null,
    
    constraint idPuestoLaboral primary key(idPuestoLaboral)
);

create table mucicipalidad(
	idMucicipalidad int unsigned auto_increment,
    nombre varchar(150) not null,
    
    constraint idMucicipalidad primary key(idMucicipalidad)
);