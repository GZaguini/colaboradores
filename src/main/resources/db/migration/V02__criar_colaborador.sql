create table colaborador(
	id int identity(1,1),
	nome varchar(50) not null,
	sobrenome varchar (50),
	id_empregador int not null,
	primary key(id),
	foreign key (id_empregador) references empregador(id)
);

insert into colaborador (nome , sobrenome , id_empregador) values
('Ana','Silva',1);
