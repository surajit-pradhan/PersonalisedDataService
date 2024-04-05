**Application features:**
This Application contains 2 interfaces
  1. Interface with data team (internal) - Receiving shoppers’ personalized 
    information and product metadata from our data team and storing it in a specified 
    database. 
  2. Interface with eCommerce (external) - Provide fast-reading operation for the 
    shoppers’ personalized information.
Below are the jsons with which internal system will push data to DB
[shelves 2.json](https://github.com/surajit-pradhan/PersonalisedDataService/files/14883619/shelves.2.json)
[products 2.json](https://github.com/surajit-pradhan/PersonalisedDataService/files/14883618/products.2.json)

**Requirements:**
  
  1-Internal Interface:Implement two separate API endpoints to receive and store:
    Shopper personalized product lists (JSON object containing
    shopperId and an array of productId and relevancyScore for each
    product)
    Product metadata (JSON object containing productId , category ,
    and brand for each product)
    
  2-External Interface:Implement a high-performance, real-time GET API endpoint to retrieve a
    shopper's personalized product list.

**Design Implementations:**

    1-We have used springboot,java8 for developement.
    
    2-MySQL for persistence DB.
    
    3-Redis cache for fast optimized data query.

Find below files for detailed requirements
[HomeAssignment_Recommendations.pdf](https://github.com/surajit-pradhan/PersonalisedDataService/files/14883710/HomeAssignment_Recommendations.pdf)
[Backend software developer - HomeAssignment (1).pdf](https://github.com/surajit-pradhan/PersonalisedDataService/files/14883709/Backend.software.developer.-.HomeAssignment.1.pdf)

Below are the redis and postman collection details
[REDIS_INSTALL.txt](https://github.com/surajit-pradhan/PersonalisedDataService/files/14883761/REDIS_INSTALL.txt)
[PersonalisedService.postman_collection.json](https://github.com/surajit-pradhan/PersonalisedDataService/files/14883762/PersonalisedService.postman_collection.json)
