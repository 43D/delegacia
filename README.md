# boletim

Demonstração de API REST em Spring Boot
<hr>
<br>

# Endpoints

## Home Page
Página inicial da API
```
GET: /delegacia/
```
> RESPONSE: status 200 application/json

<hr>
<br>
<br>

## Boletins
#### Obter vários Boletins
Você pode resgatar os 50 primeiros boletins do sistema

```
GET: /delegacia/boletim
```
> RESPONSE: status 200 application/json

<br>

#### Filters
Para obter boletins, você pode usar alguns filtros. Todos eles podem ser combinados entre si.

<br>

##### Pages
Os boletins são divididos em páginas com 50 itens, você pode escolher qual página com o filtro __*page*__.
```
GET: /delegacia/boletim?page=7
```
> RESPONSE: status 200 application/json

<br>

##### Periodos
Você pode filtras os resultados com o filtro __*periodo*__.
Retorna apenas os 50 primeiros itens, mais que isso utilizar o filtro __*page*__.

```sh
OPÇÔES:
        manha
        tarde
        noite
        madrugada
        incerta
```
```
GET: /delegacia/boletim?periodo=manha
```
> RESPONSE: status 200 application/json

<br>

##### Cidades
Você pode filtras os resultados com o filtro __*cidade*__.
Retorna apenas os 50 primeiros itens, mais que isso utilizar o filtro __*page*__.

```
GET: /delegacia/boletim?cidade=CARAGUATATUBA
```
> RESPONSE: status 200 application/json
<hr>
<br>

#### Obter Boletim por ID
Você pode resgatar um boletim pelo seu ID

```
GET: /delegacia/boletim/{id}
```
> RESPONSE: status 200 application/json

<hr>
<br>

#### Criar um novo Boletim
Você pode criar um novo boletim

```
POST: /delegacia/boletim
```

```
BODY application/json:
{
    "dataOcorrencia": "05-05-2023",
    "periodoOcorrencia": "manha",
    "flagrante": true,
    "partes": [
        {
            "nome": "Allan Fel",
            "email": "a@g.com",
            "telefone": "45998989999",
            "tipoEnvolvimento": "sim"
        }
    ],
    "localOcorrencia": {
        "logradouro": "Rua josé",
        "numero": "S/n",
        "bairro": "sei lá",
        "cidade": "toledo",
        "estado": "pr"
    },
    "veiculoFurtado": {
        "emplacamento": {
            "placa": "aaa1238",
            "estado": "mato grosso",
            "cidade": "toledo do sul"
        },
        "anoFabricacao": 2023,
        "cor": "azul",
        "marca": "Volks",
        "tipoVeiculo": "Automovel"
    }
}
```
> RESPONSE: status 201 application/json

<hr>
<br>


#### Atualizar Boletim por ID
Você pode atualizar um boletim pelo seu ID

```
PUT: /delegacia/boletim/{id}
```

```
BODY application/json:
{
    "dataOcorrencia": "05-05-2023",
    "periodoOcorrencia": "manha",
    "flagrante": true,
    "partes": [
        {
            "nome": "Allan Fel",
            "email": "a@g.com",
            "telefone": "45998989999",
            "tipoEnvolvimento": "sim"
        }
    ],
    "localOcorrencia": {
        "logradouro": "Rua josé",
        "numero": "S/n",
        "bairro": "sei lá",
        "cidade": "toledo",
        "estado": "pr"
    },
    "veiculoFurtado": {
        "emplacamento": {
            "placa": "aaa1238",
            "estado": "mato grosso",
            "cidade": "toledo do sul"
        },
        "anoFabricacao": 2023,
        "cor": "azul",
        "marca": "Volks",
        "tipoVeiculo": "Automovel"
    }
}
```
> RESPONSE: status 201 application/json

<hr>
<br>

#### Deletar Boletim por ID
Você pode deletar um boletim pelo seu ID

```
DEL: /delegacia/boletim/{id}
```
> RESPONSE: status 200

<hr>
<br>

### Veiculos
```
GET: /delegacia/veiculo
```
> RESPONSE: status 200 application/json
