# Desafio Técnico - Analista Desenvolvedor Web Shift

Projeto para resolver o desafio técnico para vaga de Analista Desenvolvedor Web da Shift. 
Implementa uma API utilizando Quarkus nos seguintes endpoints:
- <b>/orcamento</b> - para gerenciar o cadastro de orçamentos
- <b>/itemOrcamento</b> - para gerenciar os itens do orçamento


## Entregáveis do Desafio

### 1. Diagrama de Classe

Documento com sintaxe plantuml na pasta `./docs/diagrama_classe.txt`

![Diagrama de Classe](https://www.plantuml.com/plantuml/png/ZLH1Znez3BtFhuWuVHyggBroMihkIdle5cdHtarYHfOoCKqSXBhgVs_2b4mYAjGBa1VRxptRuI48U8c3xRI54DGMGs1ufa0Qr4Ud59cLUd62FVfqSZpWIhs99zUdepuUgfC1WLS8cWPqmYlr28893dZc4lMh-qFqpAde5demxAzCwWwLq35LsQNF9dCg-Drhk13Vo1wLlOCb0mQBhWnkm40GFuazWMM_Om6R84nMm5xHHmmwKNDzOHBcIGDNIeE0n31gVRlyJk21NEB_2IP5VcMs26wIllMiqT2e7i-2pWJr8ZXyDCRhi2avn-rWZpPryIgrbgZPKF-N0OmvMu-Q_w7zv4WJlrEFJXEKTXreQB5SlsjdE_ioK_E5MQZPV5QpTXtiWtZGeYOdzwNqTSlLhQUroIeTsAQBgcrZ2SfvwEBGefVeJGp2tq3G4zXonXG3O_jLSdA6zBLs60G3GLFjThitx4xeA6TkmGlfQ26RuoYUGvNSpddC9HzzJvh7EY5QoTHFvoIcP8whrhw2fs6TrovW5dhqV0AJQxm2brDAppsw3ETsHF_bkqyrzBzQBgkTIzEUA6UVbyjS9YxcUUhDdqczhdUUwkt-_X239U3UM-HzG7-2-Z7MvkQZky9zzLQ0ugmWxI9VxSsJlwfCzu3EnC7-1W00)

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

[Swagger Editor](https://editor.swagger.io/?url=http://teste.com/arquivo.yaml)

## Observações

### Decisões da modelagem de classe e Implementação
- Utilizei uma classe pai chamada `Item` para representar os procedimentos e adicionais, para facilitar o relacionamento com a classe `Orcamento` e `TabelaPreço`.<br>Esta decisão provavelmente complicaria o mapeamento para o banco de dados relacional ao utilizar o ORM, contudo poderia facilmente ser revertida criando os relacionamentos direto com as classes `Procedimento` e `Adicional` com duas propriedades de lista ao invés de apenas uma na classe `Orcamento`.   
- Adicionei na modelagem o controle de `TabelaPreco` para deixar mais próximo da realidade, ao invés de colocar um campo de valor direto no `Item`. Desta forma o `Procedimento` e `Adicional` poderiam estar relacionados a mais de uma `FontePagadora` através da `TabelaPreco`.
- Não utilizei banco de dados apenas uma classe `Dados` com listas para fazer a simulação de tabelas para testar os endpoints. 

### Pontos de Melhoria
- Adicionar o controle de segurança e permissão e classe para `Usuario`, representando quem fez os cadastros e alterações.
- Foi utilizado campo Id como Integer, poderia ter sido implementado com UUID para facilitar a geração
- Separar as classes de input request para não permitir passagem de valores desnecessários.
