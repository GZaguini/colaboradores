create table empregador (
	id int Identity (1,1),
	nome varchar (150),
	identificador varchar (18),
	Primary key (id)
);

insert into empregador (nome, identificador) values
('Havan','14.234.232/0001-45');
