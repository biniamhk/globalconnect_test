installation requirement:
Java JDK 11+ (Recommend Java 17)
Maven latest
MySQl
Any IDE that support Java (Recommend Intellij)
Mysql credential
username: root
password: biniam2011

Endpoints/JSON:
  //After validate Isbn the valid isbn only saved in databas.
   //Isbn10 endpoints
1.  Sending Isbn10 to be validated
    POST:localhost:8080/globalconnect/api/isbn10/validate
     eg: {
    "isbn":"097470587x"
    }
2. get valid Isbn10 from database by Isbn10
   GET: localhost:8080/globalconnect/api/isbn10/findValidIsbn10/{isbn}
3. get all valid Isbn10 from Database
   GET: localhost:8080/globalconnect/api/isbn10/findAllValidIsbn10
4. Delete isbn10 from database by Id which is PK.
   DELETE: localhost:8080/globalconnect/api/isbn10/removeIsbn/{id}

////Isbn13 endpoints
1.  Sending Isbn13 to be validated
       POST:localhost:8080/globalconnect/api/isbn13/validate
       eg: {
       "isbn":"9783161484100"
       }
2. get valid Isbn13 from database by Isbn13
   GET: localhost:8080/globalconnect/api/isbn13/findValidIsbn13/{isbn}
3. get all valid Isbn13 from Database
   GET: localhost:8080/globalconnect/api/isbn13/findAllValidIsbn13
4. Delete isbn10 from database by Id which is PK.
   DELETE: localhost:8080/globalconnect/api/isbn13/removeIsbn/{id}