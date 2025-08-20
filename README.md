# Forum Hub - API REST

Este é o repositório do projeto **Forum Hub**, uma API REST desenvolvida como desafio do programa ONE da Alura. A API gerencia um sistema de fórum, permitindo operações CRUD (Criar, Ler, Atualizar, Excluir) em tópicos e implementando um sistema de autenticação e autorização com JWT (JSON Web Token).

---

### 🚀 Funcionalidades

A API oferece as seguintes funcionalidades principais:

* **CRUD de Tópicos**:
    * **Criar** novos tópicos (POST).
    * **Listar** todos os tópicos existentes, com paginação (GET).
    * **Detalhar** um tópico específico por ID (GET).
    * **Atualizar** informações de um tópico existente (PUT).
    * **Excluir** um tópico por ID (DELETE).
* **Autenticação e Autorização**:
    * **Login de Usuário**: Endpoint para autenticar um usuário e gerar um token JWT.
    * **Proteção de Rotas**: Todas as rotas de gerenciamento de tópicos são protegidas e exigem um token JWT válido no cabeçalho `Authorization`.

### 🛠️ Tecnologias Utilizadas

* **Java 21**: Linguagem de programação.
* **Spring Boot 3.x**: Framework para a construção da API.
* **Spring Security**: Para autenticação e autorização.
* **JWT (JSON Web Token)**: Padrão para geração e validação de tokens de segurança.
* **Spring Data JPA**: Para persistência de dados com o banco de dados.
* **MySQL**: Banco de dados relacional.
* **Flyway**: Gerenciamento de migrações de banco de dados.
* **Lombok**: Para simplificar a escrita de classes de modelo (entidades e DTOs).
* **Maven**: Gerenciador de dependências.

### 🏃 Como Rodar o Projeto

1.  **Clone o Repositório**:
    ```bash
    git clone [https://github.com/seu-usuario/forumhub.git](https://github.com/seu-usuario/forumhub.git)
    cd forumhub
    ```

2.  **Configurar o Banco de Dados**:
    * Certifique-se de ter o MySQL instalado e em execução.
    * Crie um banco de dados com o nome `forumhub`.
    * Atualize as configurações de conexão em `src/main/resources/application.properties`:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
        spring.datasource.username=seu_usuario_do_mysql
        spring.datasource.password=sua_senha_do_mysql
        ```

3.  **Executar o Projeto**:
    * Pode ser executado diretamente pela sua IDE (IntelliJ, Eclipse, etc.).
    * Ou via linha de comando com o Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

### 📋 Endpoints da API

* **Autenticação**
    * `POST /login`
        * **Corpo da Requisição**: `{"login": "seu_login", "senha": "sua_senha"}`
        * **Resposta**: Retorna um token JWT válido.

* **Tópicos**
    * `POST /topicos`
        * **Cabeçalho**: `Authorization: Bearer <token_jwt>`
        * **Corpo da Requisição**: `{"titulo": "...", "mensagem": "...", "autorId": 1, "cursoId": 1}`
    * `GET /topicos`
        * **Cabeçalho**: `Authorization: Bearer <token_jwt>`
        * **Parâmetros**: `?page=0&size=10` (opcional, para paginação)
    * `GET /topicos/{id}`
        * **Cabeçalho**: `Authorization: Bearer <token_jwt>`
    * `PUT /topicos/{id}`
        * **Cabeçalho**: `Authorization: Bearer <token_jwt>`
        * **Corpo da Requisição**: `{ "titulo": "Novo Titulo", "mensagem": "Nova mensagem" }` (os campos são opcionais)
    * `DELETE /topicos/{id}`
        * **Cabeçalho**: `Authorization: Bearer <token_jwt>`

---

Este projeto demonstra a construção de uma API REST segura e funcional, aplicando as melhores práticas do ecossistema Spring Boot.
