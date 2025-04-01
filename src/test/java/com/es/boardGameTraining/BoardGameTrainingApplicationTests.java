package com.es.boardGameTraining;

import com.es.boardGameTraining.model.Game;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions.*;

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

}
