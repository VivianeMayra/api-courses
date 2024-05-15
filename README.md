# API Courses

O projeto **API Courses** é um serviço web RESTful desenvolvido com Spring Boot, projetado para gerenciar uma coleção de cursos. Esta API fornece endpoints para criar, atualizar, recuperar e deletar cursos, além de funcionalidade para alternar o status de um curso entre ativo e inativo.

## Funcionalidades

- **Criar Curso**: Adicionar novos cursos ao sistema.
- **Ler Cursos**: Recuperar todos os cursos ou filtrar por nome e categoria.
- **Atualizar Curso**: Modificar detalhes de cursos existentes.
- **Deletar Curso**: Remover cursos do sistema.
- **Alternar Status do Curso**: Alternar o status de um curso entre ativo e inativo.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework utilizado para construir a API.
- **Hibernate**: ORM para interações com o banco de dados.
- **JPA**: API de Persistência Java para persistência de dados.
- **Lombok**: Reduz código boilerplate para classes modelo.
- **PostgreSQL**: Banco de dados utilizado para armazenar os dados dos cursos.
- **Docker**: Utilizado para criar e gerenciar o banco de dados PostgresSQL.

## Começando

### Pré-requisitos

- Java 17 ou superior instalado.
- Maven instalado.
- Docker instalado.

### Instalação e Execução

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seudonome/api-courses.git
   cd api-courses
   ```

2. **Configure o banco de dados usando Docker**:

- Crie e inicie um contêiner Docker com PostgresSQL:

  ```bash
    docker run --name postgres-db -e POSTGRES_DB=apicourses -e POSTGRES_USER=yourusername -e POSTGRES_PASSWORD=yourpassword -p 5432:5432 -d postgres
  ```

- Atualize o arquivo application.properties com os detalhes do seu banco de dados:

  ```bash
  spring.datasource.url=jdbc:postgresql://localhost:5432/apicourses
  spring.datasource.username=yourusername
  spring.datasource.password=yourpassword
  spring.jpa.hibernate.ddl-auto=update
  ```

3. **Construa e execute a aplicação**

```bash
 ./mvnw spring-boot:run
```

### Propriedades que uma task deve ter:

- id : Identificador único de cada curso
- name : Nome do curso
- category : Categoria do curso
- status : Define se um curso está ativo ou não
- created_at : Data de quando o curso foi criado
- updated_at : Deve ser alterado para a data de quando o curso for atualizado

### Rotas:

- POST - /cursos/
- GET - /cursos/
- PUT - /cursos/:id
- DELETE - /cursos/:id
- PATCH - /cursos/:id/active
