# API de Usuários com Autenticação JWT

Este projeto é uma API REST desenvolvida com **Spring Boot**, com foco em cadastro e autenticação de usuários utilizando **JWT (JSON Web Token)**.

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

* ✅ Cadastro de usuário
* ✅ Login com geração de token JWT
* ✅ Autenticação via token
* ✅ CRUD de usuários
* ✅ Senhas criptografadas com BCrypt
* ✅ Proteção de rotas

---

## Autenticação

A autenticação é feita via **JWT**.

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

## Rotas protegidas

Para acessar rotas protegidas, envie o token no header:

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

## Configuração do banco

Configure o arquivo:

```
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/projeto_api
spring.datasource.username=root
spring.datasource.password=senha
```

---

## Como rodar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/api-usuarios-springboot.git
```

2. Acesse a pasta:

```bash
cd api-usuarios-springboot
```

3. Execute:

```bash
mvn spring-boot:run
```

---

## Testes

Você pode testar utilizando o **Postman** ou qualquer cliente HTTP.

---
