# VehicleCrudApp
Spring Boot application For Vehicle Crud

 please check out the branch develop  not master branch to find the application
# Status code	Usage

# 200 OK
The request completed successfully.
# 201 Created
A new resource has been created successfully. The resource’s URI is available from the response’s Location header.
# 204 No Content
An update to an existing resource has been applied successfully.
# 400 Bad Request
The request was malformed. The response body will include an error providing further information.
# 404 Not Found
The requested resource did not exist.
# 500 Internal Server Error
Unexpected condition that could not be handled by the application.

# HTTP Verbs #
# GET	
Used to retrieve a resource

# POST	
Used to create a new resource

# PUT	
Used to update an existing resource

# DELETE	
Used to delete an existing resource

# All the URLs for test the API Car

GET /car/

GET /car/{id}

GET /car/model/{description}

GET /car/carmarker/{description}

GET /car/color/{description}

GET /car/mileage/{description}

GET /car/motor/{description}


POST /car/

PUT /car/{id}

DELETE /car/{id}

# All the URLs for test the API moto

GET /moto/

GET /moto/{id}

GET /moto/model/{description}

GET /moto/carmarker/{description}

GET /moto/color/{description}

GET /moto/mileage/{description}

GET /moto/motor/{description}


POST /moto/

PUT /moto/{id}

DELETE /moto/{id}

# All the URLs for test the API Model

GET /model/

GET /model/{id}

POST /model/

PUT /model/{id}

DELETE /model/{id}

# All the URLs for test the API Assembler
GET /assembler/

GET /assembler/{id}

POST /assembler/

PUT /assembler/{id}

DELETE /assembler/{id}

