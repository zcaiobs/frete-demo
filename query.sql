create extension dblink;


select * from business;

select dblink_connect('host=localhost user=admin password=admin dbname=business');

select business.name, business.preco, teste.name as ref, teste.quantidade, (business.preco*teste.quantidade) as total
from dblink('user=admin password=admin dbname=business','select name, preco FROM business')
    as business(
    name character varying(255),
    preco double precision
)inner join teste on teste.name = business.name group by business.name, business.preco, teste.name, teste.quantidade


CREATE TABLE
  public.teste (
    id uuid NOT NULL,
    name character varying(255),
    quantidade double precision
  );
  
  insert into teste (id, name, quantidade) values ('002646b4-57a9-4b4b-8a0c-3e63a5289cb2', 'Produto 2', 5.0)

ALTER TABLE
  public.teste
ADD
  CONSTRAINT teste_pkey PRIMARY KEY (id)
  
  
drop table business;
select * from pg_database;
create database teste;
drop database teste;


select * from business;
