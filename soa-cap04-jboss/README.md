# SOA - Capítulo 4

Projeto relativo ao capítulo 4 do livro, adaptado para rodar no JBoss Application Server. 

## Requisitos

* JBoss Application Server 7.1.1.Final (Obtido em http://www.jboss.org/jbossas/downloads/)

## Como utilizar

* Inicialize o JBoss AS.
* Execute o comando mvn package jboss-as:deploy
* Confira os logs

## Diferenças entre o anterior (soa-cap04-jetty)

* Os arquivos web.xml e sun-jaxws.xml foram removidos
* O plugin do Jetty foi removido do pom.xml
* A dependência jaxws-rt foi comentada (agora, a engine padrão do JBoss AS será utilizada)
* A dependência jboss-ejb-api_3.1_spec foi adicionada (para que o Maven possa compilar EJB's)
* O plugin maven-war-plugin foi declarado para ignorar a falta do arquivo web.xml
