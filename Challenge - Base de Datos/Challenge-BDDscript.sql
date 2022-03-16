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

DELIMITER $$
CREATE PROCEDURE obtenerEmpleados( )
BEGIN 
		select e.nombre, e.apellido, e.telefono, e.email, e.salario, e.inicioActividades, pl.nombre as 'Puesto Laboral', m.nombre as 'Municipalidad' 
		from puestoLaboral pl
		inner join empleado e 
		on pl.idPuestoLaboral=e.idPuestoLaboral
		inner join municipalidad m
		on m.idMunicipalidad=e.idMunicipalidad
		group by e.nombre
		having (e.salario > 70000) && (datediff(curdate() , e.inicioActividades)/365) <= 15 && ((datediff(curdate() , e.inicioActividades)/365) >= 10);
END; $$
CALL obtenerEmpleados();

DELIMITER $$
CREATE PROCEDURE EmpleadosXSalarioYAntiguedadMinMax(IN eSalario float, IN eAntiguedadMin int , IN eAntiguedadMax int )
BEGIN 
		select e.nombre, e.apellido, e.telefono, e.email, e.salario, e.inicioActividades, pl.nombre as 'Puesto Laboral', m.nombre as Municipalidad 
		from puestoLaboral pl
		left join empleado e 
		on pl.idPuestoLaboral=e.idPuestoLaboral
		inner join municipalidad m
		on m.idMunicipalidad=e.idMunicipalidad
		having ((e.salario > eSalario) && ((datediff(curdate() , e.inicioActividades)/365) <= eAntiguedadMax && ((datediff(curdate() , e.inicioActividades)/365) >= eAntiguedadMin)))
        order by  Municipalidad asc;
END; $$
CALL EmpleadosXSalarioYAntiguedadMinMax(70000, 10, 15);
drop procedure EmpleadosXSalarioYAntiguedadMinMax;


DELIMITER $$
CREATE PROCEDURE insertarMunipalidad(IN mNombre varchar(150))
BEGIN 
INSERT INTO municipalidad(nombre) VALUES(mNombre);
END; $$
CALL insertarMunipalidad('Pinamar');
select * from municipalidad;

DELIMITER $$
CREATE PROCEDURE insertarPuestoLaboral(IN pNombre varchar(150))
BEGIN 
INSERT INTO puestoLaboral(nombre) VALUES(pNombre);
END; $$
CALL insertarPuestoLaboral('Secretario');
select * from puestoLaboral;

DELIMITER $$
CREATE PROCEDURE insertarEmpleado(IN eNombre varchar(150), IN eApellido varchar(150), IN eTelefono varchar(150), IN eEmail varchar(150), 
									IN eIdPuestoLaboral int, IN eIdMunicipalidad int, IN eSalario float, IN eInicioActividades date )
BEGIN 
INSERT INTO empleado(nombre, apellido, telefono, email, idPuestoLaboral, idMunicipalidad, salario, inicioActividades) 
			VALUES(eNombre, eApellido, eTelefono, eEmail, eIdPuestoLaboral, eIdMunicipalidad, eSalario, eInicioActividades );
END; $$
CALL insertarEmpleado('Sandra','Soto','555555555','sandrasoto@email.com',5,6,77500.50,'2009-07-25');
select * from empleado;