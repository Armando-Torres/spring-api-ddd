[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/summary/new_code?id=Armando-Torres_spring-api-ddd)

[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=Armando-Torres_spring-api-ddd&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=Armando-Torres_spring-api-ddd) [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=Armando-Torres_spring-api-ddd&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=Armando-Torres_spring-api-ddd) [![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=Armando-Torres_spring-api-ddd&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=Armando-Torres_spring-api-ddd) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Armando-Torres_spring-api-ddd&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Armando-Torres_spring-api-ddd) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Armando-Torres_spring-api-ddd&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=Armando-Torres_spring-api-ddd)

# How-To

## Description

This projects are an API to serve tasks across endpoints. You can Create, get or modify data talking with REST. 

## Setup dev environment

Only for the first time you must run the next command:
```shell
docker compose -f compose.dev.yaml up -d
```

It rise up a tomcat in port 80 and database exposed into 3306, both available in localhost.

## Start / Stop

#### Start services
You can init services typing:
```shell
docker compose -f compose.dev.yaml start
```

#### Stop services
```shell
docker compose -f compose.dev.yaml stop
```

## Container logs

#### Tomcat log
```shell
docker compose -d compose.dev.yaml logs -f api
```

#### MariaDB log
```shell
docker compose -d compose.dev.yaml logs -f db
```

## Tomcat

#### Credentials to manager
Use admin for user and same for password.

#### Auto apps deployment
You can deploy new wars using the tomcat manager. It is exposed into 80 under the path: /manager/html. Or click on the next link [access to tomcat manager](http://localhost:80/manager/html)

#### Manual apps deployment
Other way is copy your .war into webapps dir to deploy by yourself. The complete path is: /usr/local/tomcat/webapps

## MariaDB

#### Default database
If database not exists on volume a new one will be created with:
- database: task_manager

#### Credentials
For root user the password are: m4_r14d8*

Standar user are created with previous grants on task_manager database:
- user: api
- passwd: 4p1**

## MAVEN
Are included with Maven Wrapped 
