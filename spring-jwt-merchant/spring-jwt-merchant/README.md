ENDPOINTS :
POST - http://localhost:8080/authenticate
POST - http://localhost:8080/products

GET  - http://localhost:8080/products
GET  - http://localhost:8080/products/sortByPrice
GET  - http://localhost:8080/products/sortByInventory

TechStack:

Spring Boot, 
Spring Security
JWT
H2
Java
RestAPI
Kafka, Zookeper
Docker


CONFIGURATION

Messaging System:

1) Install Kafka 
set up (server.properties / zookeeper.properties)
set up environment variables
2) Run Zookeeper : 
>zookeeper-server-start config/zookeeper.properties
3) Run Kafka :
>kafka-server-start config/server.properties
4) Create topic  - Kafka_Product_Topic
kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Product_Topic
5) Create consumer -
bin>kafka-console-consumer --bootstrap-server localhost:9092 --topic Kafka_Product_Topic --from-beginning


ENDPOINTS DETAILED:

1) POST
http://localhost:8080/authenticate
Body:
{
    "username": "USER",
    "password": "PASSWORD"
}
Response:
{
    "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVU0VSIiwiZXhwIjoxNjAwNDQ5NjczLCJpYXQiOjE2MDA0MTM2NzN9.dPvFGN7gVRzOhGFlX_AVDFFIzU4qKZnYm0nlH6K7bgY"
}

2) POST
http://localhost:8080/products
Headers:
Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVU0VSIiwiZXhwIjoxNjAwNDQ5NjczLCJpYXQiOjE2MDA0MTM2NzN9.dPvFGN7gVRzOhGFlX_AVDFFIzU4qKZnYm0nlH6K7bgY
Content-Type : application/json

Body:
{
  "productCategory": "ELECTRONICS",
  "name": "TV",
  "description":"LG Smart TV" , 
  "unitPrice": 1000.00 ,
  "inventory":15,
  "paymentOptions": "DIRECT",
  "deliverOptions": "X"
}

POST
http://localhost:8080/products
Headers:
Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVU0VSIiwiZXhwIjoxNjAwNDQ5NjczLCJpYXQiOjE2MDA0MTM2NzN9.dPvFGN7gVRzOhGFlX_AVDFFIzU4qKZnYm0nlH6K7bgY
Content-Type : application/json

{
  "productCategory": "FASHION",
  "name": "Skirt 101",
  "description": "Black Skirt",
  "unitPrice": 20.00,
  "inventory": 10,
  "paymentOptions": "INSTALLMENT",
  "deliverOptions": "X"
}

POST
http://localhost:8080/products
Headers:
Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVU0VSIiwiZXhwIjoxNjAwNDQ5NjczLCJpYXQiOjE2MDA0MTM2NzN9.dPvFGN7gVRzOhGFlX_AVDFFIzU4qKZnYm0nlH6K7bgY
Content-Type : application/json
{
  "productCategory": "FOOD",
  "name": "Bread",
  "description": "Whole Wheat Bread",
  "unitPrice": 5,
  "inventory": 3,
  "paymentOptions": "DIRECT",
  "deliverOptions": "X"
}


3) GET
http://localhost:8080/products
Headers:
Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVU0VSIiwiZXhwIjoxNjAwNDQ5NjczLCJpYXQiOjE2MDA0MTM2NzN9.dPvFGN7gVRzOhGFlX_AVDFFIzU4qKZnYm0nlH6K7bgY
Content-Type : application/json

Response
[
    {
        "id": 2,
        "productCategory": "ELECTRONICS",
        "name": "TV",
        "description": "LG Smart TV",
        "unitPrice": 1000.00,
        "inventory": 15,
        "paymentOptions": "DIRECT",
        "deliverOptions": "X"
    },
    {
        "id": 3,
        "productCategory": "FASHION",
        "name": "Skirt 101",
        "description": "Black Skirt",
        "unitPrice": 20.00,
        "inventory": 10,
        "paymentOptions": "INSTALLMENT",
        "deliverOptions": "X"
    }
]

4) GET

http://localhost:8080/products/sortByPrice
Headers:
Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVU0VSIiwiZXhwIjoxNjAwNDQ5NjczLCJpYXQiOjE2MDA0MTM2NzN9.dPvFGN7gVRzOhGFlX_AVDFFIzU4qKZnYm0nlH6K7bgY
Content-Type : application/json

Response
[
    {
        "id": 2,
        "productCategory": "FASHION",
        "name": "Skirt 101",
        "description": "Black Skirt",
        "unitPrice": 20.00,
        "inventory": 10,
        "paymentOptions": "INSTALLMENT",
        "deliverOptions": "X"
    },
    {
        "id": 1,
        "productCategory": "ELECTRONICS",
        "name": "TV",
        "description": "LG Smart TV",
        "unitPrice": 1000.00,
        "inventory": 15,
        "paymentOptions": "DIRECT",
        "deliverOptions": "X"
    }
]


5) GET

http://localhost:8080/products/sortByInventory
Headers:
Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVU0VSIiwiZXhwIjoxNjAwNDQ5NjczLCJpYXQiOjE2MDA0MTM2NzN9.dPvFGN7gVRzOhGFlX_AVDFFIzU4qKZnYm0nlH6K7bgY
Content-Type : application/json

Response
[
    {
        "id": 2,
        "productCategory": "FASHION",
        "name": "Skirt 101",
        "description": "Black Skirt",
        "unitPrice": 20.00,
        "inventory": 10,
        "paymentOptions": "INSTALLMENT",
        "deliverOptions": "X"
    },
    {
        "id": 1,
        "productCategory": "ELECTRONICS",
        "name": "TV",
        "description": "LG Smart TV",
        "unitPrice": 1000.00,
        "inventory": 15,
        "paymentOptions": "DIRECT",
        "deliverOptions": "X"
    }
]
