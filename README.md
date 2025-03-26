# Board Game Training

## Project Name
**Board Game and Match Management System**

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
