# LeafSaver

This project is an API for LeafSaver application written in Spring Boot

## Setting up

In order ro run this application you need to set up:
- `java` development environment (IntelliJ preferred)
- `maven`
- `mysql` database

### Configuration variables

You will need to set up fallowing environment variables in order to successfully run this application:
- `LEAFSAVE_DB_HOST` - hostname or ip address of `mysql` server
- `LEAFSAVER_DB` - name of database on which you want to operate
- `LEAFSAVER_DB_USERNAME` - database serveer user
- `LEAFSAVER_DB_PASSWORD` - password for  database user

### Profiles

Application supports two profiles:
- `dev`
- `production`

To set up profile set `spring_profiles_active` environment variable to desired value.

In `dev` profile you will get detailed logging as well as actuator details about application.

### Database initialization

In `dev` profile you can trigger database initialization by passing `--init-db` command line argument. If you are running application through `mvn spring-boot:run` or `mvnw spring-boot:run` add `-Dspring-boot.run.arguments=--init-db` command line option.

This will populate database with data for development purposes.
