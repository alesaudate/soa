insert into Autor (nome) values ('Paulo Silveira') 
insert into Autor (nome) values ('Adriano Almeida')
insert into Autor (nome) values ('Vinicius Baggio Fuentes')

insert into Livro (anoDePublicacao,editora,nome,resumo) values (2012,'Casa do Código','Guia do Programador','Vá do "nunca programei"...')
insert into Livro (anoDePublicacao,editora,nome,resumo) values (2012,'Casa do Código','Ruby on Rails','Crie rapidamente aplicações web')

insert into Livro_Autor (livro_id,autores_id) values (1,1)
insert into Livro_Autor (livro_id,autores_id) values (1,2)
insert into Livro_Autor (livro_id,autores_id) values (2,3)