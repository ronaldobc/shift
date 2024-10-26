# Desafio Técnico - Analista Desenvolvedor Web Shift

Projeto para resolver o desafio técnico para vaga de Analista Desenvolvedor Web da Shift. 
Implementa uma API utilizando Quarkus no seguinte endpoint:
- <b>/orcamento</b> - para gerenciar o cadastro de orçamentos



## Entregáveis do Desafio

### 1. Diagrama de Classe

Documento com sintaxe plantuml na pasta `./docs/diagrama_classe.txt`

![Diagrama de Classe](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/ronaldobc/shift/refs/heads/master/docs/diagrama_classe.txt)

### 2. Listagem de possíveis Endpoints da API

>Orçamento
>- adicionar
>- atualizar por id
>- retonar por id
>- retornar listagem por Fonte Pagadora ou Pessoa Física
>- remover por id

>Orçamento Item
>- adicionar
>- atualizar por id
>- retonar por id
>- retornar listagem por Orçamentos
>- remover por id

>Pessoa Física
>- Adicionar
>- Atualizar por id
>- Retornar por cpf ou id
>- remover por id

>Item (Procedimento e Adicionais)
>- Adicionar
>- atualizar por id
>- Retornar por id
>- retornar listagem por categoria (procedimento/adicional) ou tipo dentro da categoria 
>- remover por id

>Fonte Pagadora
>- adicionar
>- atualizar por id
>- retonar por id
>- remover por id

>Tabela Preço
>- adicionar
>- atualizar por id
>- retornar por id
>- retornar listagem por Fonte Pagadora ou Período de Vigência 
>- remover por id

>Tabela Preço Item
>- adicionar
>- atualizar por id
>- retornar por id
>- retonar listagem por Tabela de Preço
>- remover por id

### 3. Documentação da API implementada

Documento em formato OpenAPI yaml na pasta `./docs/doc_api.yaml`

[Swagger Editor](https://editor.swagger.io/?url=https://raw.githubusercontent.com/ronaldobc/shift/refs/heads/master/docs/doc_api.yaml)

## Observações

### Decisões na modelagem  do Diagrama de Classe e Implementação
- Utilizei uma classe pai chamada `Item` para representar os procedimentos e adicionais, para facilitar o relacionamento com a classe `Orcamento` e `TabelaPreço`.<br>Esta decisão provavelmente complicaria o mapeamento para o banco de dados relacional ao utilizar o ORM, contudo poderia facilmente ser revertida criando os relacionamentos direto com as classes `Procedimento` e `Adicional` com duas propriedades de lista ao invés de apenas uma na classe `Orcamento`.   
- Adicionei na modelagem o controle de `TabelaPreco` para deixar mais próximo da realidade, ao invés de colocar um campo de valor direto no `Item`. Desta forma o `Procedimento` e `Adicional` poderiam estar relacionados a mais de uma `FontePagadora` através da `TabelaPreco`.
- Não utilizei banco de dados, pois não tinha nada especificado na descrição do desafio. Criei apenas uma classe `Dados` com listas para fazer a simulação de tabelas para testar os endpoints. 

### Pontos de Melhoria
- Adicionar o controle de segurança e permissão e classe para `Usuario`, representando quem fez os cadastros e alterações.
- Foi utilizado campo Id como Integer, poderia ter sido implementado com UUID para facilitar a geração
- Separar as classes de input request para não permitir passagem de valores desnecessários.
- Ajustes na validação das regras de negócio em uma classe específica da camada de negócios.
