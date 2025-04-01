package com.es.boardGameTraining;

import com.es.boardGameTraining.model.Game;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class BoardGameTrainingApplicationTests {

	@Test
	public void testGameOne() {

		 long bggID = 1234567;
		 String title = "Erase Una vez";
		 String urlImg = "Paco Martinez";
		 String type = "Kichio";
		 Integer year = 2016;
		 Game g = new Game();

		 g.setBggId(bggID);
		 g.setTitle(title);
		 g.setUrlImage(urlImg);
		 g.setType(type);
		 g.setYear(year);

		 assertEquals(bggID, g.getBggId()); // comprueba que el parametro que recibe es igual que el contenido de bggID
		 assertEquals(title, g.getTitle());
		 assertEquals(urlImg, g.getUrlImage());
		 assertEquals(type, g.getType());
		 assertEquals(year, g.getYear());

	}

	@Test
	public void testGameWithAuthorsAndArtists() {
		Long bggID = 1234567L;
		String title = "Erase una vez";
		String urlImg = "Paco Martinez";
		String type = "Kichio";
		Integer year = 2016;
		List<String> authors = List.of("Autor 1", "Autor 2");
		List<String> artists = List.of("Artista 1", "Artista 2");

		Game g = new Game();
		g.setBggId(bggID);
		g.setTitle(title);
		g.setUrlImage(urlImg);
		g.setType(type);
		g.setYear(year);
		g.setAuthors(authors);
		g.setArtists(artists);

		assertEquals(bggID, g.getBggId());
		assertEquals(title, g.getTitle());
		assertEquals(urlImg, g.getUrlImage());
		assertEquals(type, g.getType());
		assertEquals(year, g.getYear());
		assertEquals(authors, g.getAuthors());
		assertEquals(artists, g.getArtists());
	}


	// verifica si las propiedades de la clase Game tienen valores predertminados esperados, que en este caso son 0
	@Test
	public void testGameWithDefaultValues() {
		Game g = new Game();

		assertEquals(null, g.getMinPlayers());  // Si el valor predeterminado es 0
		assertEquals(null, g.getMaxPlayers());
		assertEquals(null, g.getMinPlayTime());
		assertEquals(null, g.getMaxPlayTime());
	}

	@Test
	public void testGameWithPlayerAndPlayTimeRange() {
		Long bggID = 1234567L;
		String title = "Juego de Rango";
		String urlImg = "imagenUrl";
		String type = "Estrategia";
		Integer year = 2018;
		Integer minPlayers = 1;
		Integer maxPlayers = 4;
		Integer minPlayTime = 30;
		Integer maxPlayTime = 90;

		Game g = new Game();
		g.setBggId(bggID);
		g.setTitle(title);
		g.setUrlImage(urlImg);
		g.setType(type);
		g.setYear(year);
		g.setMinPlayers(minPlayers);
		g.setMaxPlayers(maxPlayers);
		g.setMinPlayTime(minPlayTime);
		g.setMaxPlayTime(maxPlayTime);

		assertEquals(minPlayers, g.getMinPlayers());
		assertEquals(maxPlayers, g.getMaxPlayers());
		assertEquals(minPlayTime, g.getMinPlayTime());
		assertEquals(maxPlayTime, g.getMaxPlayTime());
	}

	@Test
	public void testGameWithUrlThumbnail() {
		Long bggID = 1234567L;
		String title = "Erase una vez";
		String urlImg = "Paco Martinez";
		String urlThumbnail = "http://url_thumbnail.com";
		String type = "Kichio";
		Integer year = 2016;

		Game g = new Game();
		g.setBggId(bggID);
		g.setTitle(title);
		g.setUrlImage(urlImg);
		g.setUrlThumbnail(urlThumbnail);
		g.setType(type);
		g.setYear(year);

		assertEquals(urlThumbnail, g.getUrlThumbnail());
	}

	@Test
	public void testUpdateGameTitle() {
		Long bggID = 1234567L;
		String title = "Juego Inicial";
		String updatedTitle = "Juego Actualizado";
		String urlImg = "Paco Martinez";
		String type = "Kichio";
		Integer year = 2016;

		Game g = new Game();
		g.setBggId(bggID);
		g.setTitle(title);
		g.setUrlImage(urlImg);
		g.setType(type);
		g.setYear(year);

		assertEquals(title, g.getTitle());  // Verificar el título inicial

		g.setTitle(updatedTitle);

		assertEquals(updatedTitle, g.getTitle());  // Verificar el título después de la actualización
	}

}
