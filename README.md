# Test of docker-maven-plugin

[![License](https://img.shields.io/github/license/mabrarov/java-exit-code.svg)](https://github.com/mabrarov/java-exit-code/tree/master/LICENSE)

Test of Java exit code.

## Building

If remote Docker engine is used then `DOCKER_HOST` environment variable should point to that engine
and include schema, like `tcp://docker-host:2375` instead of `docker-host:2375`.

Building with [Maven Wrapper](https://github.com/takari/maven-wrapper):

```bash
./mvnw clean package -Pdocker
```

or on Windows:

```bash
mvnw.cmd clean package -Pdocker
```

## Running

```bash
docker run --rm -it abrarov/java-se-exit-code
```

or 

```bash
docker run --rm -it abrarov/spring-boot-exit-code
```
