# desafio_spring

## O que é
Trata-se de exercício promovido pela Digital House referente ao aprendizado de spring boot.
## Como instalar
1 - Faça um clone do repositório
```shell
git clone git@github.com:hugomeli/desafio_spring.git
```
2 - Você pode executar a aplicaçao pela sua IDE ou pelo comando abaixo na pasta raiz do projeto
```shell
./mvnw spring-boot:run
```
## Documentaçao
O exercício pode ser acessado no caminho [/documentacao/exercicio.pdf](documentacao/exercicio.pdf)
A documentaçao da API pode ser acessada no caminho [/documentacao/api.pdf](documentacao/api.pdf)

## Melhorias feitas

* Caso tente acessar um userId (Usuario ou Vendedor) que não exista, retornará 404 - Not Found.
* Caso o id da publicação já exista, a mesma não será cadastrada e retornará Bad Request.
* Ao cadastrar uma publicacão (promocional ou não) há a verificação dos campos recebidos.
* Caso o parâmetro de ordenação seja inválido, retornará 400 Bad Request.
* No Requisito US 0012 é possível pesquisar por ordem alfabética. Para isso, 
os métodos serão os seguintes:
  - GET /products/{userId}/list?order=name_asc
  - GET /products/{userId}/list?order=name_desc
  - Obs.: o método padrão continua em vigor. GET /products/{userId}/list