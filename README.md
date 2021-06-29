# NerdAPI
NerdAPI é uma API Rest desenvolvida com Spring. Nesta aplicação foram utilizadas as stacks:
- Spring Boot
- Spring Security
- Spring Data JPA
- JSON Web Token
- Swagger 2
- PostgreSQL
## Apresentação
A aplicação consome um serviço externo chamado SWAPI, uma API que fornece dados acerca da saga **StarWars**, e disponibiliza dados em português dos filmes, planetas e pessoas envolvidas nos filmes.

## EndPoints
NerdAPI possui dois EndPoints públicos, **"/user"**(POST) e **"/auth"**(POST), o endpoint **user** permite que usuário faça cadastro na aplicação, fornecendo seu nome, email e senha, além disso permite que um usuário autenticado altere sua senha através de uma requisição `PUT`.

Já o endpoint **auth** é responsável pela autenticação do usuário no sistema, servindo como login para quem estar a acessar os demais serviços disponíveis, o usuário deve inserir o seu email e respectiva senha.

A aplicação permite também consultas para usuários previamente autenticados. São os endpoints **"/pessoas"**,  **"/filmes"**,  **"/planetas"** que fornecem dados acerca da saga, sendo possível passar um id como `PathVariable`, trazendo apenas um objeto de acordo com a consulta(Filme, Pessoa ou Planeta).

## Desenvolvimento
Como citado anteriormente a aplicação dispões de um sistema de autenticação e autorização por meio do `Spring Security` + JWT, limitando o acesso a enpoints privados apenas para usuários autenticados.

Como ORM foi utilizado o `Spring Data JPA`, fazendo a comunicação com um banco de dados PostgreSQL.

O `Swagger` disponibiliza um endpoint `"/swagger-ui.html"`, fornecendo uma breve documentação da aplicação e a possibilidade de realizar testes dos **controllers** disponíveis.

Os testes foram realizados com `MockMvc`e `JUnit5`, para testes dos **`controllers`** que requerem a realização de uma requisição e para testes unitários nos `serviços` e `Dtos`.
