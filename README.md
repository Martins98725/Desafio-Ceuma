# Desafio prático do ceuma

Projeto é um CRUD padrão que visa fazer um controle sobre Cursos e Alunos

## Uso do Projeto

### Consultar todos os cursos ###

**Endpoint:** `GET http://localhost:8080/cursos`

**Descrição:** Recupera todos os dados do curso.
### Consultar curso expecifico ###

**Endpoint:** `GET http://localhost:8080/cursos/id do curso`

**Descrição:** Recupera um curso expecifico atraves do seu id  passado na URL.

### Cadastrar curso ###

**Endpoint:** `POST http://localhost:8080/cursos/`

**Descrição:** Adiciona um curso.

### Deletar curso ###

**Endpoint:** `DELETE http://localhost:8080/cursos/id do curso`

**Descrição:** Deleta o curso cujo o id foi passado na URL.

### Atualizar curso ###

**Endpoint:** `PUT http://localhost:8080/cursos/id do curso`

**Descrição:** Atualiza o curso cujo o id foi passado na URL.


### Consultar todos os alunos ###

**Endpoint:** `GET http://localhost:8080/alunos`

**Descrição:** Recupera todos os dados do aluno.
### Consultar aluno expecifico ###

**Endpoint:** `GET http://localhost:8080/alunos/id do aluno`

**Descrição:** Recupera um aluno expecifico atraves do seu id  passado na URL.

### Cadastrar aluno ###

**Endpoint:** `POST http://localhost:8080/alunos/`

**Descrição:** Adiciona um aluno.

### Deletar aluno ###

**Endpoint:** `DELETE http://localhost:8080/alunos/id do aluno`

**Descrição:** Deleta o aluno cujo o id foi passado na URL.

### Atualizar aluno ###

**Endpoint:** `PUT http://localhost:8080/alunos/id do aluno`

**Descrição:** Atualiza o aluno cujo o id foi passado na URL.




***Corpo para requisição de POST para alunos*** 
`{
"nome": "",
"cpf": "00000000000000",
"endereco": "",
"cep": "65110-000",
"email": "example@gmail.com",
"numeroDeTelefone": "123456789012",
"curso": "id do curso que o aluno vai ser atrelado"
}`

***Corpo para requisição de PUT para alunos***
`{
"nome": "",
"endereco": "",
"cep": "65110-000",
"email": "example@gmail.com",
"numeroDeTelefone": "123456789012",
"curso": "id do curso que o aluno vai ser atrelado"
}`


***Corpo para requisição de POST para cursos***
`{
"nome":"",
"cargaHoraria":""
}`

***Corpo para requisição de PUT para cursos***
`{
"nome":"",
"cargaHoraria":""
}`
