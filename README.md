# CERS - COVID-19 Entrance Recording System

![eslint](https://github.com/Yukiho-YOSHIEDA/CERS/workflows/eslint/badge.svg?branch=master&event=push)
![JUnit](https://github.com/Yukiho-YOSHIEDA/CERS/workflows/JUnit/badge.svg?branch=master&event=push)
![Version 1.0](https://img.shields.io/badge/version-1.0-yellow.svg)
[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](LICENSE)

This system record someone entered or leaved the room.

![Screenshots](./screenshots.png)

## Require
* Java OpenJDK 11
* docker-compose
* Node.js v12.16.1

## Downloads
* [v1.0(latest)](https://github.com/Yukiho-YOSHIEDA/CERS/releases/download/v1.0/cers-1.0.jar)
* [v0.1](https://github.com/Yukiho-YOSHIEDA/CERS/releases/download/v0.1/cers-0.0.1-SNAPSHOT.jar)

## How to run
`$ java -jar cers.jar`
* Default port is 8080.
* When you want to change port number to 80, run `$ java -Dserver.port=80 -jar cers.jar`.

## How to run on development environment
1. Clone this repository.
1. Run `$ cd cers` on your turminal.
1. Run `$ docker-compose up -d`.
1. On macOS or Linux OS, Run `$ ./gradlew bootRun`. On windows, Run `$ ./gradlew.bat bootRun`.
1. Access http://localhost:8080 .

## How to run front-end development environment
1. Run `$ cd cers/front` on your turminal.
1. Run `$ npm run serve`.

## How to build application
1. Run `$ cd cers` on your turminal.
1. On macOS or Linux OS, Run `$ ./gradlew build`. On windows, Run `$ ./gradlew.bat build`.
1. When build successful, you can find .jar file in `build/libs`.

## API docs
This project support Swagger UI.
1. Run CERS develop environment.
1. Access http://localhost:8080/swagger-ui.html .

## Terminal devices
* [CERS-terminal](https://github.com/greenlaver/CERS-terminal) by Aonori.

## LICENSE
Under MIT License.
