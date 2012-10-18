# SOA - Capítulo 5

Projeto relativo ao capítulo 5 do livro.  

## Requisitos

* JBoss Application Server 7.1.1.Final (Obtido em http://www.jboss.org/jbossas/downloads/)


## Como utilizar

* Inicialize o JBoss AS.
* Execute o comando mvn package jboss-as:deploy
* Confira os logs

## Diferenças entre o anterior (soa-cap04-jboss)

Contém um serviço de validação de CPF's. Para utilizar, basta inicializar a aplicação (conforme descrito acima) e apontar o browser para as seguintes URL's:

* http://localhost:8080/soa-cap05-0.0.1-SNAPSHOT/services/validador/cpf/12345678909?algoritmo=MODULO11 (deve retornar HTTP 200, ou seja, uma página em branco)
* http://localhost:8080/soa-cap05-0.0.1-SNAPSHOT/services/validador/cpf/12345678909 (deve retornar HTTP 400, ou seja, uma página de erro)
* http://localhost:8080/soa-cap05-0.0.1-SNAPSHOT/services/validador/cpf/53389399321 (HTTP 200)
* http://localhost:8080/soa-cap05-0.0.1-SNAPSHOT/services/validador/cpf/64573128530 (HTTP 200)
* http://localhost:8080/soa-cap05-0.0.1-SNAPSHOT/services/validador/cpf/53783947677 (HTTP 200)
* http://localhost:8080/soa-cap05-0.0.1-SNAPSHOT/services/validador/cpf/79780901671 (HTTP 200)
* http://localhost:8080/soa-cap05-0.0.1-SNAPSHOT/services/validador/cpf/75538117774 (HTTP 200) 
  
  

 
