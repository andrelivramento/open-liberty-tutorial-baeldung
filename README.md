### Relevant stuff
- [Source (not very reliable...)](https://www.baeldung.com/java-open-liberty)
- [Main landing page](http://localhost:9080)
- [mpHealth](http://localhost:9080/health)
- [AppServlet / @Webservlet](http://localhost:9080/app)
- **GET**:
```curl --request GET --url http://localhost:9080/api/persons```
- **POST**:
```curl --request POST --url http://localhost:9080/api/persons --header 'content-type: application/json' --data '{"username": "andre", "email": "andre@livramento.com"}'```
- **GET**:
    ```curl --request GET --url http://localhost:9080/api/persons/1```
    
- Running application

```bash
mvn clean package
mvn liberty:dev
```
