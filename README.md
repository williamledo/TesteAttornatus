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

•	Deletar pessoa pelo Id   -    DELETE  localhost:8080/pessoas/{id}


•	Consultar pessoa pelo Id   -    GET  localhost:8080/pessoas/{id}


•	Listar pessoas   -     GET  localhost:8080/pessoas


•	Atualizar pessoa pelo Id   -     PUT  localhost:8080/pessoas/id

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
