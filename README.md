# Modified Petclinic app for Demo

## Changes made to upstream code:

- move readme.md to upstream-readme.md
- modified docker-compose.yml to start petclinic in addition to mysql for a fully self contained environment.
- modified petclinic to have two datasources, petclinic and pii, to get petclinic some sensitive pii information
    - The Owner object was copied to a Customer object.  The Customer object is considered PII.
    These objects are accessible via the `/customers/..` REST path.
- Added a sample SQLI vulnerability on the `DELETE /customers/{customerId}` REST path.
- modified docker-compose.yml to run an Agent and read config from the local `/agent` dir where people
can change Agent binaries and configs without needing to change any docker-compose config or other code/config
files.
- Add multi-stage Dockerfile to build petclinic and produce a docker image. It
doesn't require a person to have any dev tools installed as all building happens in the docker image
- Change database initialization from default springboot directives to manually configured beans because
springboot doesn't support automatic initialization of multiple datasources.
- Add a fake "diagnostics" page just for some interesting demo content.
- Add Basic user/password auth to `/customers/*` endpoints.
  - The username is `user` and the password is `password`.
- Add outbound service call to an astrology service on the welcome page
- Add a file read action to get the welcome message for the welcome page.

### To build new Docker image
```asciidoc
docker build -t local/petclinic:latest .    
```

### To launch App and DB
```asciidoc
docker compose-up
```

### To build locally
```asciidoc
./mvnw clean package -DskipTests=true     
```

Hint: For quicker development you can kill the petclinic docker container but leave the DB container
running.  Then you can launch a local petclinic and it will use the DB container.  (This
app instance won't be running with the Contrast agent, however.)
```asciidoc
java -jar target/spring-petclinic-3.1.0-SNAPSHOT.jar     
```
