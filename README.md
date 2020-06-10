# spring-boot-liquibase

## Deploy postgres database and create database
```shell script
docker exec -it postgresql_docker psql -U user -c "create database test_db"
```

## Liquibase with Spring Boot Actuator

* Adding the dependency
```maven
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
* Expose the actuator endpoints
```yaml
management:
  endpoints:
    web:
      exposure:
        include: '*'
```

* Running Application class
* Navigate to /actuator/liquibase and see liquibase changelogs
```json
{
    "contexts": {
        "application": {
            "liquibaseBeans": {
                "liquibase": {
                    "changeSets": [
                        {
                            "author": "phea_soy",
                            "changeLog": "db/changelog/db.changelog-1.0.yml",
                            "comments": "",
                            "contexts": [],
                            "dateExecuted": "2020-06-10T12:08:56.688Z",
                            "deploymentId": "1790936597",
                            "description": "createTable tableName=book",
                            "execType": "EXECUTED",
                            "id": "20200607-book",
                            "labels": [],
                            "checksum": "8:d36f52811534408ff7b0d08b71b9ef9f",
                            "orderExecuted": 1,
                            "tag": null
                        },
                        {
                            "author": "phea_soy",
                            "changeLog": "db/changelog/db.changelog-1.1.yml",
                            "comments": "",
                            "contexts": [],
                            "dateExecuted": "2020-06-10T12:08:56.739Z",
                            "deploymentId": "1790936597",
                            "description": "createTable tableName=book_category",
                            "execType": "EXECUTED",
                            "id": "20200607-book_category",
                            "labels": [],
                            "checksum": "8:c6622893d0fdfaccde571c8790ffe174",
                            "orderExecuted": 2,
                            "tag": null
                        },
                        {
                            "author": "phea_soy",
                            "changeLog": "db/changelog/db.changelog-1.0.yml",
                            "comments": "",
                            "contexts": [],
                            "dateExecuted": "2020-06-10T13:46:44.896Z",
                            "deploymentId": "1796804851",
                            "description": "insert tableName=book",
                            "execType": "EXECUTED",
                            "id": "20200607-book-insert",
                            "labels": [],
                            "checksum": "8:ab78260a54c4abb80f666a6b708174f3",
                            "orderExecuted": 3,
                            "tag": null
                        },
                        {
                            "author": "phea_soy",
                            "changeLog": "db/changelog/db.changelog-1.0.yml",
                            "comments": "",
                            "contexts": [
                                "prod"
                            ],
                            "dateExecuted": "2020-06-10T13:46:44.913Z",
                            "deploymentId": "1796804851",
                            "description": "insert tableName=book",
                            "execType": "EXECUTED",
                            "id": "20200607-book-insert-2",
                            "labels": [],
                            "checksum": "8:c50cf9d90b93796173fc44533de832db",
                            "orderExecuted": 4,
                            "tag": null
                        }
                    ]
                }
            },
            "parentId": null
        }
    }
}
```

