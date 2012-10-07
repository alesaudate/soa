# SOA - Capítulo 4

Projeto relativo ao capítulo 4 do livro, adaptado para rodar no Jetty. 

## Requisitos

* Nenhum (o download do Jetty será feito automaticamente pelo Maven)

## Como utilizar

* Execute o comando mvn jetty:run
* Confira os logs

## Diferenças entre o anterior (soa-cap03)

* O arquivo pom.xml foi alterado para transformar o arquivo em WAR 
* O arquivo pom.xml inclui as dependências do JAX-WS
* Os arquivos sun-jaxws.xml e web.xml foram criados