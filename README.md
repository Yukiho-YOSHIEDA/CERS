# CERS - COVID-19 Entrance Recording System

This system record someone entered or leaved the room.

## Require
* Java OpenJDK 11
* docker-compose

## How to run
`$ java -jar cers.jar`

## How to run on demelopment enviroment
1. Clone this repository.
1. Run `$ cd cers` on your turminal.
1. Run `$ docker-compose up -d`.
1. On macOS or Linux OS, Run `$ ./gradlew bootRun`. On windows, Run `$ ./gradlew.bat bootRun`.
1. Access http://localhost:8080/swagger-ui.html .

## API docs
This project support Swagger UI.
1. Run CERS develop enviroment.
1. Access http://localhost:8080/swagger-ui.html .

## LICENSE
Under MIT License.
