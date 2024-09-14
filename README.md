# Projeto Spring Boot com PostgreSQL, Flyway e OpenAPI

[![Em Desenvolvimento](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)]()

## Visão Geral

## Visão Geral

Este é um projeto simples de **agendamento de consultas médicas** desenvolvido com **Spring Boot**. A aplicação possui duas tabelas principais, `patients` e `appointments`, e seu objetivo é gerenciar o cadastro de pacientes e agendar consultas. Apesar de ser um projeto básico, ele aborda os **fundamentos de uma API REST**, incluindo operações CRUD, migrações de banco de dados e documentação automática da API.

O projeto é ideal para quem deseja aprender ou reforçar conceitos como:

- Criação de uma **API REST** com endpoints para gerenciar recursos.
- Uso de **PostgreSQL** como banco de dados relacional.
- Gerenciamento de migrações com **Flyway**.
- Geração de documentação interativa com **OpenAPI**.



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
git clone https://github.com/Rickson-Rocha/Appointments-API.git
cd Appointments-API
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