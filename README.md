# Spring based REST Webservice

This project is small Spring base REST Service which uses following technologies:

- Java 1.8
- In Memory Database H2
- Spring MVC / Spring Boot
- Maven

## Getting Started

The webservice can be started by issuing following command at root directory of project.

```sh
$ cd webservice
$ mvn spring-boot:run
```

### Running Integration Tests

Integration tests can be run separetly by issuing following command

```sh
$ mvn verify
```
## Request & Response Examples
#### Base url
```sh
https://secret-eyrie-11493.herokuapp.com/
```
### API Resources


- [GET /companies](#get_companies)
- [GET /companies/{id}](#get_companiesid)
- [POST /companies](#post_companies)
- [PUT /companies/{id}](#put_companiesid)
- [PUT /companies/{id}/addBO](#put_addBeneficialOwner)

### GET /companies
Example `curl`
```
curl GET \
  https://secret-eyrie-11493.herokuapp.com/companies
```
Response:
```
[
    {
        "id": 1001,
        "name": "BMW",
        "address": "Berlin warburg str.22001",
        "city": "Berlin",
        "country": "Germany",
        "email": "bmw@xyz.de",
        "phoneNumber": "9988083727",
        "beneficialOwners": [
            {
                "name": "Peter"
            }
        ]
    }
]
```

### GET /companies/{id}
Example `curl`
```
curl -X GET \
  https://secret-eyrie-11493.herokuapp.com/companies/1001
```

### POST /companies
Example `curl`
```
curl -X POST \
  https://secret-eyrie-11493.herokuapp.com/companies \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
        "name": "Doodle",
        "address": "Berlin XYZ 1999",
        "city": "Berlin",
        "country": "Germany",
        "email": "g@gmail.com",
        "phoneNumber": "35393000283",
        "beneficialOwners": [{"name":"Russel"},{"name":"James"}]
}'
```
### PUT /companies/{id}
It the same as `POST` request with an exception of passing the `id` as well.

Note: Since in current implantation certain fields are mandatory (requirement in task) to be provided so in order to make a `put` request all those fields will have to be provided as well otherwise it will fail due to `validation` error.

### PUT /companies/{id}/addBO
Example `curl`
```
curl -X PUT \
  http://localhost:8080/companies/1001/addBO \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
        "beneficialOwners": [{"name":"Russel"},{"name":"James"}]
}'
```
