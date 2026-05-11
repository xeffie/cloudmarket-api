# CloudMarket API

CloudMarket is a simple second-hand marketplace REST API built with Spring Boot.

## Features

- Create listings
- Get all listings
- Get listing by id
- Update listings
- Delete listings
- Basic error handling

## Tech stack

- Java
- Spring Boot
- Maven
- REST API

## API endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /api/listings | Create a new listing |
| GET | /api/listings | Get all listings |
| GET | /api/listings/{id} | Get listing by id |
| PUT | /api/listings/{id} | Update listing |
| DELETE | /api/listings/{id} | Delete listing |
| GET | /api/health | Check if API is running |

## Example JSON

```json
{
  "title": "iPhone 13",
  "description": "Fungerar bra, några små repor.",
  "price": 4200,
  "category": "Electronics",
  "itemCondition": "USED",
  "sellerName": "Anna Svensson",
  "status": "AVAILABLE"
}
