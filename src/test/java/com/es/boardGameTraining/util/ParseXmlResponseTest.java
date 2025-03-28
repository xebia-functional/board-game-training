package com.es.boardGameTraining.util;

import com.es.boardGameTraining.dto.GameBggDTO;
import com.es.boardGameTraining.model.Game;
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
    public void parseXmlResponseGameBGG_validXml_shouldReturnGames() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items total=\"1\" termsofuse=\"https://boardgamegeek.com/xmlapi/termsofuse\">\n" +
                "    <item type=\"boardgame\" id=\"5166\">\n" +
                "        <name type=\"primary\" value=\"Express Monopoly Card Game\"/>\n" +
                "        <yearpublished value=\"1993\"/>\n" +
                "    </item>\n" +
                "</items>";

        List<GameBggDTO> games = parseXmlResponse.parseXmlResponseGameBGG(xml);

        assertNotNull(games);
        assertFalse(games.isEmpty());

        GameBggDTO game = games.get(0);
        assertEquals(5166, game.getId());
        assertEquals("Express Monopoly Card Game", game.getName());
        assertEquals(1993, game.getYearPublished());
    }

    // Test to validate that the method returns an empty list when given an empty XML
    @Test
    public void parseXmlResponseGameBGG_emptyXml_shouldReturnEmptyList() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><items></items>";

        List<GameBggDTO> games = parseXmlResponse.parseXmlResponseGameBGG(xml);

        assertNotNull(games);
        assertTrue(games.isEmpty());
    }

    // Test to validate that the method handles XML without the yearPublished tag gracefully
    @Test
    public void parseXmlResponseGameBGG_noYearPublished_shouldHandleGracefully() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items total=\"1\" termsofuse=\"https://boardgamegeek.com/xmlapi/termsofuse\">\n" +
                "    <item type=\"boardgame\" id=\"5166\">\n" +
                "        <name type=\"primary\" value=\"Express Monopoly Card Game\"/>\n" +
                "    </item>\n" +
                "</items>";

        List<GameBggDTO> games = parseXmlResponse.parseXmlResponseGameBGG(xml);

        assertNotNull(games);
        assertFalse(games.isEmpty());

        GameBggDTO game = games.get(0);
        assertNull(game.getYearPublished());
    }

    // Test to validate that the method parses a valid XML and returns a game with correct data
    @Test
    public void parseXmlResponseGame_validXml_shouldReturnGame() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items termsofuse=\"https://boardgamegeek.com/xmlapi/termsofuse\">\n" +
                "    <item type=\"boardgame\" id=\"1\">\n" +
                "        <thumbnail>https://cf.geekdo-images.com/rpwCZAjYLD940NWwP3SRoA__thumb/img/YT6svCVsWqLrDitcMEtyazVktbQ=/fit-in/200x150/filters:strip_icc()/pic4718279.jpg</thumbnail>\n" +
                "        <image>https://cf.geekdo-images.com/rpwCZAjYLD940NWwP3SRoA__original/img/yR0aoBVKNrAmmCuBeSzQnMflLYg=/0x0/filters:format(jpeg)/pic4718279.jpg</image>\n" +
                "        <name type=\"primary\" sortindex=\"5\" value=\"Die Macher\"/>\n" +
                "        <name type=\"alternate\" sortindex=\"1\" value=\"德国大选\"/>\n" +
                "        <name type=\"alternate\" sortindex=\"1\" value=\"디 마허\"/>\n" +
                "        <description>Die Macher is a game about seven sequential political races in different regions of Germany. Players are in charge of national political parties, and must manage limited resources to help their party to victory. The winning party will have the most victory points after all the regional elections. There are four different ways of scoring victory points. First, each regional election can supply one to eighty victory points, depending on the size of the region and how well your party does in it. Second, if a party wins a regional election and has some media influence in the region, then the party will receive some media-control victory points. Third, each party has a national party membership which will grow as the game progresses and this will supply a fair number of victory points. Lastly, parties score some victory points if their party platform matches the national opinions at the end of the game.\n\nThe 1986 edition featured four parties from the old West Germany and supported 3-4 players. The 1997 edition supports up to five players in the re-united Germany and updated several features of the rules as well. The 2006 edition also supports up to five players and adds a shorter five-round variant and additional rules updates by the original designer.</description>\n" +
                "        <yearpublished value=\"1986\"/>\n" +
                "        <minplayers value=\"3\"/>\n" +
                "        <maxplayers value=\"5\"/>\n" +
                "        <playingtime value=\"240\"/>\n" +
                "        <minplaytime value=\"240\"/>\n" +
                "        <maxplaytime value=\"240\"/>\n" +
                "        <minage value=\"14\"/>\n" +
                "        <link type=\"boardgamecategory\" id=\"1021\" value=\"Economic\"/>\n" +
                "        <link type=\"boardgamecategory\" id=\"1026\" value=\"Negotiation\"/>\n" +
                "        <link type=\"boardgamecategory\" id=\"1001\" value=\"Political\"/>\n" +
                "        <link type=\"boardgamemechanic\" id=\"2916\" value=\"Alliances\"/>\n" +
                "        <link type=\"boardgamemechanic\" id=\"2080\" value=\"Area Majority / Influence\"/>\n" +
                "        <link type=\"boardgamemechanic\" id=\"2012\" value=\"Auction / Bidding\"/>\n" +
                "        <link type=\"boardgamefamily\" id=\"10643\" value=\"Country: Germany\"/>\n" +
                "        <link type=\"boardgamefamily\" id=\"81575\" value=\"Digital Implementations: VASSAL\"/>\n" +
                "        <link type=\"boardgamefamily\" id=\"34116\" value=\"Political: Elections\"/>\n" +
                "        <link type=\"boardgamefamily\" id=\"91\" value=\"Series: Classic Line (Valley Games)\"/>\n" +
                "        <link type=\"boardgamedesigner\" id=\"1\" value=\"Karl-Heinz Schmiel\"/>\n" +
                "        <link type=\"boardgameartist\" id=\"928\" value=\"Bernd Brunnhofer\"/>\n" +
                "        <link type=\"boardgameartist\" id=\"12517\" value=\"Marcus Gschwendtner\"/>\n" +
                "        <link type=\"boardgameartist\" id=\"4959\" value=\"Harald Lieske\"/>\n" +
                "        <link type=\"boardgamepublisher\" id=\"133\" value=\"Hans im Glück\"/>\n" +
                "        <link type=\"boardgamepublisher\" id=\"2\" value=\"Moskito Spiele\"/>\n" +
                "        <link type=\"boardgamepublisher\" id=\"24883\" value=\"Ediciones MasQueOca\"/>\n" +
                "        <link type=\"boardgamepublisher\" id=\"2726\" value=\"Portal Games\"/>\n" +
                "        <link type=\"boardgamepublisher\" id=\"15108\" value=\"Spielworxx\"/>\n" +
                "        <link type=\"boardgamepublisher\" id=\"39249\" value=\"sternenschimmermeer\"/>\n" +
                "        <link type=\"boardgamepublisher\" id=\"11652\" value=\"Stronghold Games\"/>\n" +
                "        <link type=\"boardgamepublisher\" id=\"5382\" value=\"Valley Games, Inc.\"/>\n" +
                "        <link type=\"boardgamepublisher\" id=\"8147\" value=\"YOKA Games\"/>\n" +
                "    </item>\n" +
                "</items>";


        Game game = parseXmlResponse.parseXmlResponseGame(xml);

        assertNotNull(game);
        assertEquals(1L, game.getBggId());
        assertEquals("Die Macher", game.getTitle());
        assertEquals(1986, game.getYear());
        assertEquals(3, game.getMinPlayers());
        assertEquals(5, game.getMaxPlayers());
        assertEquals(14, game.getAge());
        assertEquals(240, game.getMinPlayTime());
        assertEquals(240, game.getMaxPlayTime());
        assertEquals("https://cf.geekdo-images.com/rpwCZAjYLD940NWwP3SRoA__thumb/img/YT6svCVsWqLrDitcMEtyazVktbQ=/fit-in/200x150/filters:strip_icc()/pic4718279.jpg", game.getUrlThumbnail());
        assertEquals("https://cf.geekdo-images.com/rpwCZAjYLD940NWwP3SRoA__original/img/yR0aoBVKNrAmmCuBeSzQnMflLYg=/0x0/filters:format(jpeg)/pic4718279.jpg", game.getUrlImage());


        assertTrue(game.getAuthors().contains("Karl-Heinz Schmiel"));
        assertTrue(game.getArtists().contains("Bernd Brunnhofer"));
    }

    // Test to validate that the method returns null when given an empty XML
    @Test
    public void parseXmlResponseGameBGG_emptyXml_shouldReturnNull() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><items></items>";

        Game game = parseXmlResponse.parseXmlResponseGame(xml);

        assertNull(game);
    }

    // Test to validate that the method handles XML without the yearPublished tag gracefully
    @Test
    public void parseXmlResponseGame_noYearPublished_shouldHandleGracefully() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items termsofuse=\"https://boardgamegeek.com/xmlapi/termsofuse\">\n" +
                "    <item type=\"boardgame\" id=\"1\">\n" +
                "        <thumbnail>https://cf.geekdo-images.com/rpwCZAjYLD940NWwP3SRoA__thumb/img/YT6svCVsWqLrDitcMEtyazVktbQ=/fit-in/200x150/filters:strip_icc()/pic4718279.jpg</thumbnail>\n" +
                "        <image>https://cf.geekdo-images.com/rpwCZAjYLD940NWwP3SRoA__original/img/yR0aoBVKNrAmmCuBeSzQnMflLYg=/0x0/filters:format(jpeg)/pic4718279.jpg</image>\n" +
                "        <name type=\"primary\" value=\"Die Macher\"/>\n" +
                "        <minplayers value=\"3\"/>\n" +
                "        <maxplayers value=\"5\"/>\n" +
                "        <minage value=\"14\"/>\n" +
                "        <minplaytime value=\"240\"/>\n" +
                "        <maxplaytime value=\"240\"/>\n" +
                "    </item>\n" +
                "</items>";

        Game game = parseXmlResponse.parseXmlResponseGame(xml);

        assertNotNull(game);
        assertNull(game.getYear());
    }

    // Test to validate that the method handles XML without minPlayers and maxPlayers tags gracefully
    @Test
    public void parseXmlResponseGame_noMinMaxPlayers_shouldHandleGracefully() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items termsofuse=\"https://boardgamegeek.com/xmlapi/termsofuse\">\n" +
                "    <item type=\"boardgame\" id=\"1\">\n" +
                "        <thumbnail>https://cf.geekdo-images.com/rpwCZAjYLD940NWwP3SRoA__thumb/img/YT6svCVsWqLrDitcMEtyazVktbQ=/fit-in/200x150/filters:strip_icc()/pic4718279.jpg</thumbnail>\n" +
                "        <image>https://cf.geekdo-images.com/rpwCZAjYLD940NWwP3SRoA__original/img/yR0aoBVKNrAmmCuBeSzQnMflLYg=/0x0/filters:format(jpeg)/pic4718279.jpg</image>\n" +
                "        <name type=\"primary\" value=\"Die Macher\"/>\n" +
                "        <yearpublished value=\"1986\"/>\n" +
                "        <minage value=\"14\"/>\n" +
                "        <minplaytime value=\"240\"/>\n" +
                "        <maxplaytime value=\"240\"/>\n" +
                "    </item>\n" +
                "</items>";

        Game game = parseXmlResponse.parseXmlResponseGame(xml);

        assertNotNull(game);
        assertNull(game.getMinPlayers());
        assertNull(game.getMaxPlayers());
    }

    // Test to validate that the method handles XML without the "image" or "thumbnail" tags gracefully
    @Test
    public void parseXmlResponseGame_noImageOrThumbnail_shouldHandleGracefully() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items termsofuse=\"https://boardgamegeek.com/xmlapi/termsofuse\">\n" +
                "    <item type=\"boardgame\" id=\"1\">\n" +
                "        <name type=\"primary\" value=\"Die Macher\"/>\n" +
                "        <yearpublished value=\"1986\"/>\n" +
                "        <minplayers value=\"3\"/>\n" +
                "        <maxplayers value=\"5\"/>\n" +
                "        <minage value=\"14\"/>\n" +
                "        <minplaytime value=\"240\"/>\n" +
                "        <maxplaytime value=\"240\"/>\n" +
                "    </item>\n" +
                "</items>";

        Game game = parseXmlResponse.parseXmlResponseGame(xml);

        assertNotNull(game);
        assertNull(game.getUrlImage());
        assertNull(game.getUrlThumbnail());
    }
}
