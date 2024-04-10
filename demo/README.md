follow this guide to create a server: https://www.digitalocean.com/community
/tutorials/spring-boot-mongodb

when stuck follow this code: https://github.com/gagangupta111/spring-boot-mo
ngodb/blob/fae692855e0461d27eea15aeaa1d6e8738bfcee9/src/main/resources/application.properties

adjusted a few things -- ```.findOne(userId)``` to ```findById(userId).get()``` and some of the application.properties
    follow this guide to run a local mongodb database: https://medium.com/create-a-clocking-in-system-on-react/creating-a-local-mongodb-database-and-insert-a-document-c6a4a2102a22
    
run ```mvn spring-boot:run``` or use vscode to start the server then view on: http://localhost:8102/user
    
push up a record with:
    ```
    curl --header "Content-Type: application/json" \
      --request POST \
      --data '{"name":"brennank","userSettings": {"bike": "pulsar"}}' \
      http://localhost:8102/user/create
    {"userId":"66160e907584466769009ff5","name":"brennank","creationDate":"2024-04-10T03:59:12.324+00:00","userSettings":{"bike":"pulsar"}}

focus on the model and controller, the dal files are unnecessary!
