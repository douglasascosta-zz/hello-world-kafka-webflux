# Spring Boot Kafka Hello World with WebFlux

### Motivation
Basic Spring Boot Kafka api with Spring WebFlux
- Sends a message to Kafka topic
- Listen a message from Kafka topic
- Listen a message from Kafka topic using KStream API

### Prerequisites
- [docker](http://www.docker.com)
- [docker-compose](https://docs.docker.com/compose/install/)

### Setup
- Start Kafka stack: `docker-compose up -d` ([More details](https://docs.confluent.io/current/tutorials/build-your-own-demos.html#bring-up-services))
- Check console at `http://localhost:9021`

### Run
- Start server: `./gradlew clean bootRun`
- Request hello-world: `curl localhost:8080/hello-world`
- Check listeners logs.
