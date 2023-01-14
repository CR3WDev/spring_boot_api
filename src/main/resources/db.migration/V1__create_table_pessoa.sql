create table pessoa (
 id serial PRIMARY KEY,
 nome VARCHAR(255),
 data_de_nascimento timestamp,
 main_endereco_id integer
);