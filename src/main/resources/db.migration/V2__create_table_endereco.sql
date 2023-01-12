create table endereco (
logradouro VARCHAR(255),
cep VARCHAR(8),
numero varchar(50),
cidade VARCHAR(255),
pessoa_id integer,
CONSTRAINT fk_endereco_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id)
);