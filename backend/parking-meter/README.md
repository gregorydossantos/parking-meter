# Parking Meter API
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/gregorydossantos/projeto-sds3/blob/main/LICENSE)
<br/>This is a project from my graduate studies in architecture and Java software development at FIAP.

## About
This project consists of creating a rest api, using the main technologies available on the market.

## Technologies and Libraries:
- Java 17
- Spring-boot 3.1.0
- Database H2
- Postgres
- Docker
- Lombok
- JUnit
- Mockito
- Jacoco Report
- ModelMapper 3.1.1
- OpenAPI 2.0.2

### API Documentation
#### DDD
![Web 1](https://github.com/gregorydossantos/parking-meter/blob/develop/assets/ddd/ddd-parking-meter.png)

#### Database Model
![Web 1](https://github.com/gregorydossantos/parking-meter/blob/develop/assets/databases/parking-lot-db.png)

#### Sequence Diagram - API

#### Notes:
To create the database and upload it locally, first confirm that you have docker installed on your machine, after that follow these steps:
<br/> - cd smart-home/docker
<br/> - sudo docker-compose up -d (to start database)
<br/> - sudo docker-compose down -d (to finish database)

### Endpoints (Swagger):
After running the project, we can access the API documentation through Swagger: <br/>
Link: http://localhost:8080/swagger-ui/index.html#/

### Observation
Project is still under development ... 