# Contacts API - Projeto Spring Boot

Este é um projeto de API REST para gerenciar contatos, desenvolvido utilizando o **Spring Boot**. A API oferece operações básicas para criar, atualizar, deletar e buscar contatos, além de funcionalidades como validação de dados, pesquisa de contatos e um método PATCH para atualização parcial dos dados.

## 📝 Funcionalidades

- **Criar um contato**: Permite adicionar um novo contato com informações como nome, telefone, e-mail e endereços.
- **Obter todos os contatos**: Lista todos os contatos armazenados no sistema.
- **Buscar contatos pelo nome**: Permite buscar contatos que correspondam a um nome específico.
- **Atualizar um contato (PUT)**: Atualiza completamente um contato existente.
- **Atualizar parcialmente um contato (PATCH)**: Permite a atualização de apenas campos específicos de um contato.
- **Deletar um contato**: Exclui um contato do sistema.
- **Adicionar e listar endereços**: Cada contato pode ter um ou mais endereços associados, sendo possível listar os endereços de um contato específico.

## 🚀 Tecnologias Utilizadas

- **Spring Boot**: Framework Java para criação de APIs REST.
- **JPA (Java Persistence API)**: Para manipulação do banco de dados.
- **H2 Database**: Banco de dados em memória, utilizado para fins de desenvolvimento.
- **JUnit**: Framework para testes automatizados.
- **Maven**: Gerenciador de dependências e construção do projeto.

## 📁 Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   ├── br
│   │   │   └── ifsp
│   │   │       └── contacts
│   │   │           ├── controller      # Contém os controladores (endpoints da API)
│   │   │           ├── model           # Modelos das entidades (Contact, Address)
│   │   │           ├── repository      # Interfaces para manipulação de dados no banco
│   │   │           └── exceptions
│   └── resources
│       └── application.properties      # Configurações do Spring Boot
```

## 🛠 Como Rodar o Projeto

### Requisitos

- **Java 17** ou superior.
- **Maven** instalado na sua máquina.
- **Postman** ou **Insomnia** para testar a API (opcional).

### Passos

1. **Clonar o repositório**:
   ```bash
   git clone https://github.com/diogoalmeida34/contacts-api.git
   ```

2. **Navegar para o diretório do projeto**:
   ```bash
   cd contacts-api
   ```

3. **Rodar o projeto**:
   Se você tem o Maven instalado, pode rodar o projeto com o seguinte comando:
   ```bash
   mvn spring-boot:run
   ```
   Isso iniciará o servidor na porta **8080**.

## 🧪 Testando a API

Você pode testar os endpoints da API utilizando ferramentas como **Postman**, **Insomnia** ou **cURL**.

### Endpoints Disponíveis

- **GET /api/contacts**  
  Retorna todos os contatos.

- **GET /api/contacts/{id}**  
  Retorna um contato específico pelo ID.

- **GET /api/contacts/search**  
  Permite buscar contatos pelo nome.  
  Exemplo de uso:  
  ```
  GET /api/contacts/search?name=João
  ```

- **POST /api/contacts**  
  Cria um novo contato.  
  Corpo da requisição (JSON):
  ```json
  {
    "nome": "João Silva",
    "telefone": "999999999",
    "email": "joao@email.com",
    "addresses": [
      {
        "rua": "Rua Exemplo",
        "cidade": "São Paulo",
        "estado": "SP",
        "cep": "01234-567"
      }
    ]
  }
  ```

- **PUT /api/contacts/{id}**  
  Atualiza um contato completamente.

- **PATCH /api/contacts/{id}**  
  Atualiza parcialmente um contato.  
  Exemplo de corpo da requisição:
  ```json
  {
    "email": "novoemail@email.com"
  }
  ```

- **DELETE /api/contacts/{id}**  
  Deleta um contato pelo ID.

- **GET /api/contacts/{id}/addresses**  
  Retorna todos os endereços de um contato específico.

## 🛠 Exercícios Realizados

1. **Criar um Novo Endpoint GET**  
   Criamos um endpoint para buscar contatos pelo nome.

2. **Implementando um Método PATCH**  
   Implementamos um método PATCH para permitir a atualização parcial dos dados de um contato.

3. **REST vs SOAP**  
   Pesquisamos sobre a diferença entre APIs REST e SOAP e como elas se aplicam a diferentes cenários.

4. **Criando um Novo Modelo de Dados (Address)**  
   Adicionamos a entidade **Address** para armazenar endereços associados aos contatos, criando uma relação bidirecional entre **Contact** e **Address**.

5. **Melhorando a Validação dos Dados**  
   Adicionamos validações no modelo **Contact**, como verificação do formato do telefone e e-mail.