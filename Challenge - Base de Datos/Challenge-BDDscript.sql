create database Challenge;
use Challenge;
create table empleado(
	idEmpleado int unsigned auto_increment,
    nombre varchar(45) not null,
    apellido varchar(45) not null,
    telefono varchar(35) not null,
    email varchar(45) unique not null,
    idPuestoLaboral int unsigned not null,
    idMunicipalidad int unsigned not null,
    salario float not null,
    inicioActividades date,
    
    constraint idEmpleado primary key(idEmpleado),
    constraint idPuestoLaboral foreign key(idPuestoLaboral) references puestoLaboral(idPuestoLaboral),
    constraint idMunicipalidad foreign key(idMunicipalidad) references municipalidad(idMunicipalidad)
);

create table puestoLaboral(
	idPuestoLaboral int unsigned auto_increment,
    nombre varchar(150) not null,
    
    constraint idPuestoLaboral primary key(idPuestoLaboral)
);

create table municipalidad(
	idMunicipalidad int unsigned auto_increment,
    nombre varchar(150) not null,
    
    constraint idMunicipalidad primary key(idMunicipalidad)
);
select * from municipalidad;
INSERT INTO municipalidad(nombre) VALUES('General Pueyrredon');
INSERT INTO municipalidad(nombre) VALUES('General Alvarado');
INSERT INTO municipalidad(nombre) VALUES('Dolores');
INSERT INTO municipalidad(nombre) VALUES('Tres Arroyos');

select * from puestoLaboral;
INSERT INTO puestoLaboral(nombre) VALUES('Vialidad');
INSERT INTO puestoLaboral(nombre) VALUES('Transito');
INSERT INTO puestoLaboral(nombre) VALUES('Oficinista');
INSERT INTO puestoLaboral(nombre) VALUES('Obras Publicas');

select * from empleado;
INSERT INTO empleado(nombre,apellido,telefono,email,salario,inicioActividades,idPuestoLaboral,idMunicipalidad) VALUES('Santiago','Morales','111111111','santiagomorales@email.com',10500.50,'1980-08-13',1,1);
INSERT INTO empleado(nombre,apellido,telefono,email,salario,inicioActividades,idPuestoLaboral,idMunicipalidad) VALUES('Marcos','Arribas','222222222','marcosarribas@email.com',12500.50,'1990-10-05',2,3);
INSERT INTO empleado(nombre,apellido,telefono,email,salario,inicioActividades,idPuestoLaboral,idMunicipalidad) VALUES('Antonio','Langone','333333333','antoniolangone@email.com',14500.50,'1994-04-09',3,4);
INSERT INTO empleado(nombre,apellido,telefono,email,salario,inicioActividades,idPuestoLaboral,idMunicipalidad) VALUES('Lucas','Diaz','444444444','lucasdiaz@email.com',16500.50,'1997-01-25',4,2);

select e.nombre, e.apellido, e.telefono, e.email, e.salario, e.inicioActividades, pl.nombre as 'Puesto Laboral', m.nombre as 'Municipalidad' 
from puestoLaboral pl
inner join empleado e 
on pl.idPuestoLaboral=e.idPuestoLaboral
inner join municipalidad m
on m.idMunicipalidad=e.idMunicipalidad
group by e.nombre
having (e.salario > 70000) && (datediff(curdate() , e.inicioActividades)/365) <= 15 && ((datediff(curdate() , e.inicioActividades)/365) >= 10);