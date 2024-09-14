# Projeto Spring Boot com PostgreSQL, Flyway e OpenAPI

[![Em Desenvolvimento](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)]()

## Visão Geral

Este é um projeto construído em Java utilizando o framework **Spring Boot**, o banco de dados relacional **PostgreSQL**, a ferramenta de migração de banco de dados **Flyway** e a **OpenAPI** para documentação interativa da API. O projeto visa fornecer uma base sólida para o desenvolvimento de APIs RESTful, com versionamento de banco de dados e documentação automatizada.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para o desenvolvimento de aplicações Java com configuração mínima.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar os dados da aplicação.
- **Flyway**: Ferramenta de migração e versionamento do banco de dados.
- **OpenAPI**: Documentação interativa da API com suporte a testes de endpoints.
- **Docker**: Para a gestão de containers e serviços, facilitando o ambiente de desenvolvimento.

## Estrutura do Projeto

O projeto segue a arquitetura MVC (Model-View-Controller), com as seguintes pastas e arquivos principais:

- `src/main/java`: Contém o código-fonte da aplicação (modelos, controladores, serviços).
- `src/main/resources`: Contém os recursos da aplicação, como arquivos de configuração e migrações SQL.
  - `db/migration`: Diretório onde ficam os scripts de migração do Flyway.
  - `application.yml`: Arquivo de configuração da aplicação, onde são definidos detalhes de conexão com o banco de dados.
- `docker-compose.yml`: Arquivo de configuração do Docker Compose, usado para subir o banco de dados PostgreSQL e outros serviços.

## Requisitos

Antes de começar, você precisará ter os seguintes itens instalados em sua máquina:

- **JDK 17** ou superior
- **Maven** para gerenciamento de dependências (ou você pode usar o wrapper `mvnw` incluído)
- **Docker** com **Docker Compose** para executar os serviços de banco de dados

## Configuração do Ambiente

### 1. Clonar o Repositório

Clone o repositório do projeto para o seu ambiente local:

```bash
git clone https://github.com/usuario/projeto-spring-boot.git
cd projeto-spring-boot
```
### 2. Configurar o Banco de Dados

O arquivo docker-compose.yml está configurado para iniciar um container com PostgreSQL. Para subir o container, execute:
```bash
docker-compose up -d
```

### 3. Configurações do Aplicativo
As configurações de banco de dados e outras propriedades podem ser ajustadas no arquivo src/main/resources/application.yml. Certifique-se de que as credenciais e URL do banco de dados estejam corretas:

```bash
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/nome_do_banco
    username: usuario
    password: senha
  flyway:
    enabled: true
    locations: classpath:db/migration
  jpa:
    hibernate:
      ddl-auto: validate
```
### 4. Executar a Aplicação
Com o banco de dados em execução, você pode iniciar a aplicação localmente com o Maven:
```bash
./mvnw spring-boot:run
```

## Desenvolvimento
Este projeto está em desenvolvimento e ainda não está pronto para produção. Sinta-se à vontade para acompanhar o progresso e contribuir.