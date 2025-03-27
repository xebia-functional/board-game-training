package com.es.boardGameTraining.util;

import com.es.boardGameTraining.dto.GameBggDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ParseXmlResponseTest {
    private ParseXmlResponse parseXmlResponse;

    @BeforeEach
    void setUp() {
        parseXmlResponse = new ParseXmlResponse();
    }

    // Test to validate that the method parses a valid XML and returns a list of games with correct data
    @Test
    public void parseXmlResponseGame_validXml_shouldReturnGames() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items total=\"1\" termsofuse=\"https://boardgamegeek.com/xmlapi/termsofuse\">\n" +
                "    <item type=\"boardgame\" id=\"5166\">\n" +
                "        <name type=\"primary\" value=\"Express Monopoly Card Game\"/>\n" +
                "        <yearpublished value=\"1993\"/>\n" +
                "    </item>\n" +
                "</items>";

        List<GameBggDTO> games = parseXmlResponse.parseXmlResponseGame(xml);

        assertNotNull(games);
        assertFalse(games.isEmpty());

        GameBggDTO game = games.get(0);
        assertEquals(5166, game.getId());
        assertEquals("Express Monopoly Card Game", game.getName());
        assertEquals(1993, game.getYearPublished());
    }

    // Test to validate that the method returns an empty list when given an empty XML
    @Test
    public void parseXmlResponseGame_emptyXml_shouldReturnEmptyList() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><items></items>";

        List<GameBggDTO> games = parseXmlResponse.parseXmlResponseGame(xml);

        assertNotNull(games);
        assertTrue(games.isEmpty());
    }

    // Test to validate that the method handles XML without the yearPublished tag gracefully
    @Test
    public void parseXmlResponseGame_noYearPublished_shouldHandleGracefully() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items total=\"1\" termsofuse=\"https://boardgamegeek.com/xmlapi/termsofuse\">\n" +
                "    <item type=\"boardgame\" id=\"5166\">\n" +
                "        <name type=\"primary\" value=\"Express Monopoly Card Game\"/>\n" +
                "    </item>\n" +
                "</items>";

        List<GameBggDTO> games = parseXmlResponse.parseXmlResponseGame(xml);

        assertNotNull(games);
        assertFalse(games.isEmpty());

        GameBggDTO game = games.get(0);
        assertNull(game.getYearPublished());
    }
}
