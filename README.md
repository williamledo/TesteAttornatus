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
