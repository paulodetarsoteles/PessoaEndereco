# PessoaEndereco

Projeto de API de controle de pessoas e endereços com Springboot

BackEnd: Java; 

Tipo de projeto: API (Web) 

Framework: Springboot

Acesso a dados inicial com JPA

Banco de Dados: H2 (banco de teste em memória) 

ENDPOINTS: 
*Selecionar todas as pessoas - GET http://localhost:8080/pessoas

*Selecionar pessoa por id - GET http://localhost:8080/pessoas/{pessoaId}

*Selecionar endereço principal da pessoa por Id - GET http://localhost:8080/enderecos/findPrincipal/{pessoaId}

*Inserir pessoa - POST http://localhost:8080/pessoas
body 
{
    "nome": "Fatima",
    "dataNascimento": "1957-11-24T00:00:00Z"
}

*Atualizar pessoa por id - PUT http://localhost:8080/pessoas/{pessoaId} 
body
{
    "nome": "Fatima",
    "dataNascimento": "1957-11-24T00:00:00Z"
}

*Excluir pessoa por id - DELETE http://localhost:8080/pessoas/{pessoaId}

---

*Selecionar todos os endereços - GET http://localhost:8080/enderecos

*Selecionar endereço por Id - GET http://localhost:8080/enderecos/{enderecoId}

