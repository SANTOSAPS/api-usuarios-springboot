# API de Usuários com Autenticação JWT

API REST desenvolvida com **Spring Boot** para gerenciamento de usuários, com autenticação segura utilizando **JWT (JSON Web Token)**.

---

## Sobre o projeto

Este projeto foi criado com o objetivo de praticar e demonstrar conhecimentos em:

* Desenvolvimento de APIs REST
* Autenticação e autorização
* Segurança com Spring Security
* Boas práticas de arquitetura em Java

---

## Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Security
* JWT (jjwt)
* MySQL
* Maven

---

## Funcionalidades

* ✅ Cadastro de usuários
* ✅ Login com geração de token JWT
* ✅ Criptografia de senha com BCrypt
* ✅ Autenticação via token
* ✅ Rotas protegidas
* ✅ CRUD completo de usuários

---

## Autenticação

A autenticação é feita via token JWT.

### Login

```http
POST /usuarios/login
```

### Exemplo de requisição

```json
{
  "email": "teste@gmail.com",
  "senha": "123456"
}
```

### Resposta

```json
{
  "token": "seu_token_aqui"
}
```

---

## Acessando rotas protegidas

Adicione o token no header da requisição:

```http
Authorization: Bearer SEU_TOKEN
```

---

## Estrutura do projeto

```
controller/
service/
repository/
model/
dto/
security/
```

---

## Configuração do banco de dados

Arquivo:

```
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/projeto_api
spring.datasource.username=root
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/SANTOSAPS/api-usuarios-springboot.git
```

### 2. Acesse a pasta

```bash
cd api-usuarios-springboot
```

### 3. Execute o projeto

```bash
mvn spring-boot:run
```

---

## Testando a API

Você pode utilizar ferramentas como:

* Postman
* Insomnia

---
