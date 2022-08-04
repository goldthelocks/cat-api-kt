# Cat API

[![Build status](https://badge.buildkite.com/1cb5c67da18c20ff18a46600f3f37f9339c19b6d9659e3299c.svg?branch=master?theme=slack)](https://buildkite.com/goldthelocks/cat-api-kt)

A sample Spring Boot app using WebClient to communicate with https://thecatapi.com.

## Getting Started

### run via IDE with Spring plugin
1. Import as maven project.
2. Run as Spring Boot application.

### run via IDE without Spring plugin
1. Import as maven project.
2. Run main method in Application.java.

### run via script
```
cd cat-api-kt
sh ./scripts/publish.sh
docker-compose up cat-api
```

### run via command line
```
cd cat-api-kt
mvn spring-boot:run
```

### run via Docker
```
cd cat-api-kt
./mvnw clean install
docker build -t goldthelocks/cat-api:latest . 
docker-compose up cat-api
```

## Configuration

### The Cat API Integration
If you want to customize this project and try out other endpoints in https://thecatapi.com:

1. Sign-up at https://thecatapi.com then retrieve your API key.
2. Go to `config/application.yml`.
3. In `catapi`, uncomment `api-key` then set your API key:
     ```
      catapi:
        api-key: <your_api_key>
     ```
 
### New Relic Integration
If you want to see app metrics:

1. Sign-up at New Relic then retrieve your license key.
2. Go to `docker-compose.yml`.
3. In `services` > `cat-api` > `environment`, uncomment `NEW_RELIC_LICENSE_KEY` then set your license key.
     ```
      services:
        cat-api:
            ....
            environment:
                NEW_RELIC_LICENSE_KEY: <your_license_key>
     ```

## Run sample requests

### Get cats

```
curl -X GET 'http://<host>:<port>/v1/cats'
```

### Create a cat

```
curl -X POST 'http://<host>:<port>/v1/cats' \
-H 'Content-Type: application/json' \
-d '{
    "name": "Big Head",
    "age": 3,
    "breed": "Domestic Shorthair"
}'
```