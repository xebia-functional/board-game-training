# Board Game Training

## Nombre del proyecto
**Sistema de Gestión de Juegos de Mesa y Partidas**

## Endpoints

### 1. Jugadores - Route prefix: /players

  - `GET /`: Permite obtener la información de todos los jugadores.
    - **Entrada**: N/A.
    - **Salida**: Lista con todos los objetos PlayerDTO de los jugadores.
    - **Excepciones**:
      - Internal Server Error (Error 500): Error interno de la base de datos.
  - `GET /{nickname}`: Permite obtener información de un jugador a traves de su nickname.
    - **Entrada**: Parametro `nickname`.
    - **Salida**: Objeto PlayerDTO.
    - **Excepciones**:
      - Bad Request Exception (Error 400): El campo nickname no puede estar vacío.
      - Player not found (Error 404): No existe ningun jugador asociado a ese nickname.
      - Internal Server Error (Error 500): Error interno de la base de datos.
  - `POST /`: Permite crear un jugador.
    - **Entrada**: JSON con `nombre` y `nickname`.
    - **Salida**: Objeto PlayerDTO.
    - **Excepciones**:
      - Bad Request Exception (Error 400): Los campos nombre y nickname no pueden estar vacios.
      - Internal Server Error (Error 500): Error interno de la base de datos.

### 2. Juegos - Route prefix: /games

  - `GET /`: Permite obtener la información de todos los juegos.
    - **Entrada**: N/A.
    - **Salida**: Lista con todos los objetos GameDTO de los juegos.
    - **Excepciones**:
      - Internal Server Error (Error 500): Error interno de la base de datos.
  - `GET /{parameter}`: Permite obtener información de un juego a traves de su título, autor y edad.
    - **Entrada**: Parametro `parameter`.
    - **Salida**: Lista con objetos GameDto.
    - **Excepciones**:
      - Bad Request Exception (Error 400): El campo nickname no puede estar vacío.
      - Game not found (Error 404): No existe ningun juego asociado a esos parametros.
      - Internal Server Error (Error 500): Error interno de la base de datos.
  - `POST /{nombre}`: Permite crear un juego mediante el parámetro "nombre", obteniendo el resto de la información desde la API pública de BGG.
    - **Entrada**: Parametro nombre.
    - **Salida**: Objeto GameDTO.
    - **Excepciones**:
      - Bad Request Exception (Error 400): El campo nombre no puede estar vacío.
      - Game not found (Error 404): No existe ningun juego asociado a ese nombre.
      - Internal Server Error (Error 500): Error interno de la base de datos.
  
  ### 3. Partidas - Route prefix: /plays

  - `GET /`: Permite obtener la información de todas los juegos.
    - **Entrada**: N/A.
    - **Salida**: Lista con todos los objetos PlayDTO de las partidas.
    - **Excepciones**:
      - Internal Server Error (Error 500): Error interno de la base de datos.
  - `POST /`: Permite crear una partida.
    - **Entrada**: JSON con `localización`, `ganador` y `jugadores`.
    - **Salida**: Objeto PlayDTO.
    - **Excepciones**:
      - Bad Request Exception (Error 400): Los campos localización, ganador y jugadores no pueden estar vacíos.
      - Internal Server Error (Error 500): Error interno de la base de datos.
