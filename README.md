# TesteAttornatus

## Perguntas: 

1.	Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

    Uma boa cobertura de testes, documentação, código limpo e a segurança.

2.	Em qual etapa da implementação você considera a qualidade de software?

    Do planejamento, do desenvolvimento até a conclusão.



# API

•	Criar uma pessoa   -      POST  localhost:8080/pessoas

```
{
    "nome": "Sandra",
    "dataDeNascimento": "1994-04-20",
    "enderecos": [
        {
            "logradouro": "Rua João da Silva",
            "cep": "5123020",
            "numero": "423",
            "cidade": "Recife"
        },
        {
            "logradouro": "Rua Ferreira Cunha",
            "cep": "5231230",
            "numero": "21",
            "cidade": "Olinda"
            }
        ]
}
```

•	Editar pessoa pelo Id   -     PUT  localhost:8080/pessoas/{id_pessoa}

```
{
    "nome": "Maria",
    "dataDeNascimento": "1974-02-13",
    "enderecos": [
        {
            "logradouro": "Rua Maria da Silva",
            "cep": "5123200",
            "numero": "2",
            "cidade": "Petrolina"
        },
        {
            "logradouro": "Rua Ferreira Cunha",
            "cep": "5231230",
            "numero": "21",
            "cidade": "Olinda"
            }
        ]
}
```
•	Deletar pessoa pelo Id   -    DELETE  localhost:8080/pessoas/{id_pessoa}

•	Consultar pessoa pelo Id   -    GET  localhost:8080/pessoas/{id_pessoa}

•	Listar pessoas   -     GET  localhost:8080/pessoas

•	Criar endereço para pessoa   -     PUT  localhost:8080/endereco/{id_pessoa}

```
{
    "logradouro": "Rua Brasil",
    "cep": "1241221",
    "numero": "43",
    "cidade": "São Paulo"
}
```

•	Listar enderecos da pessoa   -     GET  localhost:8080/enderecos/{id}

•	Informar o endereco principal da pessoa   -     PUT  localhost:8080/pessoas/{id_pessoa}/{id_endereco}




