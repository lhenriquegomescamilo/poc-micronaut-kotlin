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

* After runnng the commands, open your browser on address http://localhost:8000/hello


#### Attention ####

* This application is possible to run using only 10m of memory, to make this run the command below:

```bash
$ ./gradlew build &&  java -jar -Xmx10m ./build/libs/name-of-file-generated.jar
``` 


To more info look the [docs of micronaut](https://docs.micronaut.io/1.2.0.RC2/guide/index.html#creatingServer)