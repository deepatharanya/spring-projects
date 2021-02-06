BOOK INVENTORY
===============

          
Application Overview
--------------------
1. It is a simple spring-boot app to keep inventory of books.
             
2. It has the following API's:
   1. List all books in the library
    
            curl -X GET "http://localhost:8080/api/book" -H "accept: */*"
             
   2. Create a book
    
            curl -X POST "http://localhost:8080/api/book" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"author\": \"Kathy Sierra, Bert Bates\", \"name\": \"Head First Java\"}"
            
   3. Read a single book by its Id
    
            curl -X GET "http://localhost:8080/api/book/1" -H "accept: */*"
            
   4. Update a single book using its id
    
            curl -X PUT "http://localhost:8080/api/book/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"author\": \"Kathy Sierra, Bert Bates\", \"id\": 1, \"name\": \"Head First Java\"}"
            
  5. Delete a single book using its Id

            curl -X DELETE "http://localhost:8080/api/book/5" -H "accept: */*"
     
3. To keep it simple, the service layer also does the persistance using a thread safe Map, which acts like a cache, restarting the server will wipe out the data.

4. Incorporated basic error handling to address Not Found and ID Mismatch scenarios.


Steps to Run the App
--------------------
     
1. Download the project into your local machine.  
	
2. Using a new terminal, navigate into bank-inventory and use the following commands to build and run the application - 
  
        mvn clean install
            
        mvn spring-boot:run
            
3. After the application starts, you can access the swagger using - http://localhost:8080/swagger-ui.html#
