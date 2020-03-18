# README @Receipt-Test
This is a simple test in writing codes to print receipt upon data input.

****


Composition
------
The test code is written in Java Spring RESTful structure, with following layers:

* `Controller`: To handle request and make response to client.

- `Service`: Holding bussiness logics, methods would be called out by controller upon request.

- `Repository`: Create queries and handle results from database.

- `Entity`: Data Transfer Object (with standard getters and setters).

- `Database`: In-memory h2 database is adopted, as it is for only test purpose.

* `Unit-testing`: Using Spring-boot testing module to ensure quality(correctness) of the code.

****

Guide to use the API
-----
The API has only one end-point:

#### **`location/printReceipt`**

```diff
# (default open on port 8080, i.e: `localhost:8080/printReceipt)
```

#### You can use API developing tools, [Postman](https://www.postman.com/ "Postman") for example,to send data to the API and get corresponding result.


As data should be sent in JSON, please be sure to add headers `Content-Type: application/json` in request.  
  
The end-point accepts data in JSON format as below:
```
[
  {	
    "name": "book",
    "quantity": 1,	
    "price": 17.99,
    "location": "CA"
  },
  {	
    "name": "potato chips",
    "quantity": 1,	
    "price": 3.99,
    "location": "CA"
  }
]
```

And the response from the API:
```
{
  "items":[
      {
        "name": "book",
        "quantity": 1,
        "price": 17.99,
        "location": "CA"
      },
      {
        "name": "potato chips",
        "quantity": 1,
        "price": 3.99,
        "location": "CA"
      }
    ],
  "subtotal": "21.98",
  "tax": "1.80",
  "total": "23.78"
}
```
