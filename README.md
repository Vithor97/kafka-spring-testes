
# Instruções de Uso

Este documento fornece um guia passo a passo para executar e interagir com containers Docker, especialmente para a manipulação de mensagens Kafka.

## Executar o Docker Compose

Para iniciar os serviços definidos no arquivo `docker-compose.yml`, navegue até a pasta `docker` com uma interface de linga de comando e execute o seguinte comando:

```bash
docker-compose up
```

## Entrar no Console do Docker

Para acessar o console de um container Docker em execução, utilize o comando `docker exec`. Por exemplo:

```bash
docker exec -it [CONTAINER_ID] bash
```

Substitua `[CONTAINER_ID]` pelo ID real do seu container, que pode ser encontrado com o comando `docker ps`.

## Ler Mensagens no Kafka

Para ler mensagens de um tópico específico no Kafka, use o seguinte comando:

```bash
kafka-console-consumer --topic [NOME_DO_TOPICO] --bootstrap-server localhost:9092 --from-beginning
```

Substitua `[NOME_DO_TOPICO]` pelo nome do tópico que você deseja consumir.

## Ler Mensagens de um Grupo no Kafka

Caso queira consumir mensagens de um tópico específico associado a um grupo, utilize:

```bash
kafka-console-consumer --topic [NOME_DO_TOPICO] --bootstrap-server localhost:9092 --group [NOME_DO_GRUPO]
```

Substitua `[NOME_DO_TOPICO]` e `[NOME_DO_GRUPO]` pelos nomes apropriados para o tópico e grupo.

---

Lembre-se de substituir os placeholders (ex: `[NOME_DO_TOPICO]`, `[CONTAINER_ID]`) pelos valores reais em seu ambiente. Siga estes passos para uma interação eficiente com seus containers Docker e mensagens Kafka.
