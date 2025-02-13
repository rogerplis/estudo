# Estudo
Projeto de estudo para Spring Boot

## Tecnologias utilizadas
* Java 23
* Spring Boot 3.0.0
* Maven Wrapper 3.3.2

## Como executar
 Execute o comando `./mvnw spring-boot:run` na raiz do projeto e acesse o endereço `http://localhost:8080` no navegador.

## Observações
* O projeto foi criado com o comando `spring init --type=web --project-name=estudo --package-name=com.roger.estudo --java-version=23 estudo`
* O arquivo `mvnw` foi atualizado para utilizar o Maven Wrapper 3.3.2

## Docker
* Configurado Dockerfile para utilizar a imagem `openjdk:23-ea-2-jdk-slim`
* docker-compose.yml para utilizar os services `postgres` e `java`
* rodar a imagem com `docker compose build && docker compose up`