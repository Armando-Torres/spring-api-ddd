# How-To

## Description

This projects are an API to serve tasks across endpoints. You can Create, get or modify data talking with REST. 

## Setup dev environment

Only for the first time you must run the next command:
```shell
docker compose -f compose.dev.yaml up -d
```

It rise up a tomcat in port 8080 and database exposed into 3306, both available in localhost.

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
You can deploy new wars using the tomcat manager. It is exposed into 8080 under the path: /manager/html. Or click on the next link [access to tomcat manager](http://localhost:8080/manager/html)

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
