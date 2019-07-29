### Poc with micronaut


### Running the project
```bash
# First we need install the dependency using the command:
$ ./gradlew build

# Before to run the server, we need execute the test 
$ ./gradlew test

# Starting the application
$ ./gradlew run

```

* After running the commands, open your browser on address http://localhost:8000/hello


#### Attention ####

* This application is possible to run using only **10mb** of memory, to make this run the command below:

```bash
$ ./gradlew build &&  java -jar -Xmx10m ./build/libs/name-of-file-generated.jar
``` 


### Example of message to send to server
* POST -> Creating persons
```bash
curl -X POST \
  http://localhost:8080/persons \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 8d513d44-159a-4398-ab68-6eac6f91563d' \
  -H 'cache-control: no-cache' \
  -d '{
	"name": "your_name"
}'
```

* GET -> retrieve all persons 
```bash
curl -X GET \
  http://localhost:8080/persons \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 004ed2cf-e7dc-412c-98a9-3d70830b771a' \
  -H 'cache-control: no-cache'
```

To more info look the [docs of micronaut](https://docs.micronaut.io/1.2.0.RC2/guide/index.html#creatingServer)