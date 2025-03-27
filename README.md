# Board Game Training

## Project Name
**Board Game and Match Management System**

## Cloning and Running the Project

To get started with the project, follow these steps:

### 1. Clone the repository
```sh
git clone https://github.com/xebia-functional/board-game-training.git
```

### 2. Configure `application.properties`
Create or modify the `src/main/resources/application.properties` file with the following example configuration:

```properties
# Server Configuration
server.port=8080

# JPA properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.globally_quoted_identifiers=true
spring.jpa.show-sql=true

# PostgreSQL configuration
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.driver-class-name=org.postgresql.Driver

#Database properties
spring.datasource.url=jdbc:postgresql://localhost:5432/yourDatabaseName
spring.datasource.username=postgres
spring.datasource.password=yourPassword
```
### 3. Build and Run the Project
#### Using Maven
```sh
mvn clean install
mvn spring-boot:run
```

### Using IntelliJ IDEA

#### Open the Project in IntelliJ IDEA:
1. Open IntelliJ IDEA.
2. Select **"Open"** and navigate to the folder where you cloned the project.

#### Configure Maven in IntelliJ:
1. Once the project is opened, IntelliJ should automatically detect the `pom.xml` file and configure it as a Maven project.
2. If it is not detected automatically, right-click the `pom.xml` file and select **Add as Maven Project**.

#### Run the Project:
1. Go to the `BoardGameTrainingApplication` class located in the package `com.es.boardGameTraining`.
2. Inside the class, click the Play (Run) button at the top right of IntelliJ to run the project.


#### Using Docker
Soon...

Once the application is running, you can access it at `http://localhost:8080`.

## Endpoints

### 1. Players - Route prefix: /players

  - `GET /`: Retrieves information about all players.
    - **Input**: N/A.
    - **Output**: List of all PlayerDTO objects.
    - **Exceptions**:
      - Internal Server Error (Error 500): Internal database error.
  - `GET /{nickname}`: Retrieves player information by nickname.
    - **Input**: `nickname` parameter.
    - **Output**: PlayerDTO object.
    - **Exceptions**:
      - Bad Request Exception (Error 400): The nickname field cannot be empty.
      - Player not found (Error 404): No player is associated with that nickname.
      - Internal Server Error (Error 500): Internal database error.
  - `POST /`: Creates a new player.
    - **Input**: JSON containing `name` and `nickname`.
    - **Output**: PlayerDTO object.
    - **Exceptions**:
      - Bad Request Exception (Error 400): The name and nickname fields cannot be empty.
      - Internal Server Error (Error 500): Internal database error.

### 2. Games - Route prefix: /games

  - `GET /`: Retrieves information about all games.
    - **Input**: N/A.
    - **Output**: List of all GameDTO objects.
    - **Exceptions**:
      - Internal Server Error (Error 500): Internal database error.
  - `GET /{parameter}`: Retrieves game information by title, author, or age.
    - **Input**: `parameter`.
    - **Output**: List of GameDTO objects.
    - **Exceptions**:
      - Bad Request Exception (Error 400): The parameter field cannot be empty.
      - Game not found (Error 404): No game matches the given parameters.
      - Internal Server Error (Error 500): Internal database error.
  - `GET /search/{name)`: Retrieves game information by name from the BGG API.
    - **Input**: `name`.
    - **Output**: List of games results from the BGG API.
    - **Exceptions**:
        - Bad Request Exception (Error 400): The name field cannot be empty.
        - Game not found (Error 404): No game matches the given parameters.
        - Internal Server Error (Error 500): Internal database error.
  - `POST /{id}`: Creates a game using the "id" parameter from the public BGG API.
    - **Input**: `id` parameter.
    - **Output**: GameDTO object.
    - **Exceptions**:
      - Bad Request Exception (Error 400): The id field cannot be empty.
      - Game not found (Error 404): No game matches the given id.
      - Internal Server Error (Error 500): Internal database error.
  
### 3. Matches - Route prefix: /plays

  - `GET /`: Retrieves information about all matches.
    - **Input**: N/A.
    - **Output**: List of all PlayDTO objects.
    - **Exceptions**:
      - Internal Server Error (Error 500): Internal database error.
  - `POST /`: Creates a new match.
    - **Input**: JSON containing `location`, `winner`, and `players`.
    - **Output**: PlayDTO object.
    - **Exceptions**:
      - Bad Request Exception (Error 400): The location, winner, and players fields cannot be empty.
      - Internal Server Error (Error 500): Internal database error.
