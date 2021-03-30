# Workshop Cassandra
Leia até o final

## Sobre
Projeto de departamentos e produtos utilizando o Cassandra, que é um banco de dados NoSQL do tipo família de colunas.

## Escopo de projeto
- CRUD completo de Departamentos (incluindo listagem de departamentos para que o usuário selecione um departamento)
- Busca de produtos por nome do departamento
- Busca de produtos por texto na descrição
- Buscar todos detalhes de um produto inclusive suas propriedades

## Padrão camadas adotado
![Padrão camadas adotado](https://github.com/josivaldobatista/workshop-mongo_db/blob/main/assets/Padrão_camadas_adotado.png)

## Modelo Conceitual
![Modelo Conceitual decisão](https://github.com/josivaldobatista/workshop-cassandra/blob/main/assets/modelo_conceitual_decisao.png)

![Modelo Conceitual](https://github.com/josivaldobatista/workshop-cassandra/blob/main/assets/modelo_conceitual.png)

## Observações:
Para que funcione sem problemas é preciso executar o comando abaixo no terminal dentro do cassandra, pois estou usando uma buscar com filtro
para procutar um texto em description. E porque preciso usar esse comando? Esse comando vai me permitir usar o 'LIKE' e o 'IGNORECASE' no cassandra
adicionando um indice no banco criado.

~~~
CREATE CUSTOM INDEX products_description_idx ON  products (description) USING 'org.apache.cassandra.index.sasi.SASIIndex' WITH OPTIONS = {'mode': 'CONTAINS', 'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer','case_sensitive': 'false'};
~~~
