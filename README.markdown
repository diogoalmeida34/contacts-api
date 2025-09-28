# Contacts API - Projeto Spring Boot

Este é um projeto de API REST para gerenciar contatos, desenvolvido utilizando o Spring Boot. A API oferece operações básicas para criar, atualizar, deletar e buscar contatos, além de funcionalidades como validação de dados, pesquisa de contatos, atualização parcial via PATCH e suporte a endereços.

---

## 📝 Funcionalidades

- Criar um contato
- Listar todos os contatos
- Buscar contatos pelo nome
- Atualização completa (PUT)
- Atualização parcial (PATCH)
- Deletar contatos
- Adicionar e listar endereços

---

## 🚀 Tecnologias Utilizadas

- **Spring Boot**: Framework principal para construção da API
- **JPA / Hibernate**: Para mapeamento objeto-relacional
- **H2 Database**: Banco de dados em memória para ambiente inicial
- **JUnit**: Para testes unitários
- **Maven**: Gerenciador de dependências e build

---

## 📁 Estrutura do Projeto

```
contacts-api/aula04
│   .gitattributes
│   .gitignore
│   HELP.md
│   LICENSE
│   mvnw
│   mvnw.cmd
│   pom.xml
│   README.markdown
│
├───.idea
│       .gitignore
│       compiler.xml
│       encodings.xml
│       jarRepositories.xml
│       misc.xml
│       vcs.xml
│       workspace.xml
│
├───.mvn
│   └───wrapper
│           maven-wrapper.properties
│
├───prints
│       paginacaoOrdenacao.jpg
│       Swagger UI - DOCS API.pdf
│       teste01_aula04.jpg
│       teste02_aula04.jpg
│       teste03_aula04.jpg
│       teste04_aula04.jpg
│       teste05_aula04.jpg
│       teste06_aula04.jpg
│       teste07_aula04.jpg
│       teste08_aula04.jpg
│       teste09_aula04.jpg
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───br
│   │   │       └───ifsp
│   │   │           └───contacts
│   │   │               │   ContactsApiApplication.java
│   │   │               │
│   │   │               ├───config
│   │   │               │       SwaggerConfig.java
│   │   │               │
│   │   │               ├───controller
│   │   │               │       AddressController.java
│   │   │               │       ContactController.java
│   │   │               │
│   │   │               ├───dto
│   │   │               │       AddressDTO.java
│   │   │               │       ContactDTO.java
│   │   │               │
│   │   │               ├───exceptions
│   │   │               │       GlobalExceptionHandler.java
│   │   │               │       ResourceNotFoundException.java
│   │   │               │
│   │   │               ├───model
│   │   │               │       Address.java
│   │   │               │       Contact.java
│   │   │               │
│   │   │               ├───repository
│   │   │               │       AddressRepository.java
│   │   │               │       ContactRepository.java
│   │   │               │
│   │   │               └───service
│   │   │                       AddressService.java
│   │   │                       ContactService.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───br
│               └───ifsp
│                   └───contacts
│                           ContactsApiApplicationTests.java
│
└───target
```

---

## 🛠 Como Rodar o Projeto

### ✅ Requisitos

- Java 17+
- Maven

### ✅ Executando

1. Clone o repositório:

   ```bash
   git clone https://github.com/diogoalmeida34/contacts-api.git
   ```

2. Acesse o diretório do projeto:

   ```bash
   cd contacts-api
   ```

3. Execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em: ➡️ http://localhost:8080

---

## ✅ Funcionalidades Implementadas

### Endpoints e Regras de Negócio

- **Buscar contatos por nome**\
  `GET /api/contacts/search` com parâmetro `name`.

- **Atualização parcial com PATCH**\
  `PATCH /api/contacts/{id}` permitindo modificar apenas campos específicos.

- **Modelo Address e relacionamento**\
  Criado modelo `Address` e associada a entidade `Contact` via relacionamento.

- **Validações de dados**\
  Aplicadas anotações de validação para garantir consistência das requisições.

---

## 📚 Exercícios Entregues (Documentação/Pesquisa)

### 🔹 REST vs SOAP

Pesquisa realizada e documentada, com prints salvos no diretório `/prints`.

### 🔹 Swagger (OpenAPI)

- Dependências adicionadas no `pom.xml`.

- Classe de configuração criada.

- Interface visual funcionando.

- Prints no diretório `/prints`.

---

## ✅ Banco de Dados Relacional

- ✔️ **Configuração atualizada no** `application.properties`**.**

- ✔️ **Dependências adicionadas no** `pom.xml`**.**

- Compatível com **MySQL**.

---

## ✅ Paginação e Ordenação

- ✔️ Implementado com `Pageable`.

- ✔️ Endpoints aceitam `page`, `size` e `sort`.

---

## 📌 Exercícios Finais Pendentes

### 🟠 DTOs (Data Transfer Objects)

- Criar DTOs para:

  - `Contact`

  - `Address`

- Ajustar controllers para entrada e saída utilizando os DTOs.

---

## 🚀 Entrega do Projeto

### 📂 Código-Fonte

Repositório com rotas implementadas:\
👉 https://github.com/diogoalmeida34/contacts-api/tree/aula04

Disponível na branch \`aula04\` também em formato .zip, se necessário.

### 🖼 Prints de Documentação

- Swagger e Postman salvos no diretório `/prints`.