package com.es.boardGameTraining.util;

import com.es.boardGameTraining.dto.GameBggDTO;
import com.es.boardGameTraining.model.Game;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.StringReader;
import javax.xml.xpath.*;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.InputSource;

@Service
public class ParseXmlResponse {
    public Game parseXmlResponseGame(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xml)));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        NodeList items = (NodeList) xpath.evaluate("/items/item", document, XPathConstants.NODESET);

        for (int i = 0; i < items.getLength(); i++) {
            Element item = (Element) items.item(i);
            Long bggId = Long.valueOf(item.getAttribute("id"));
            String title = ((Element) item.getElementsByTagName("name").item(0)).getAttribute("value");

            Integer year = extractIntegerValue(item, "yearpublished");
            Integer minPlayers = extractIntegerValue(item, "minplayers");
            Integer maxPlayers = extractIntegerValue(item, "maxplayers");
            Integer age = extractIntegerValue(item, "minage");
            Integer minPlayTime = extractIntegerValue(item, "minplaytime");
            Integer maxPlayTime = extractIntegerValue(item, "maxplaytime");

            String urlImage = extractStringValue(item, "image");
            String urlThumbnail = extractStringValue(item, "thumbnail");

            List<String> authors = extractMultipleValues(item, "boardgamedesigner");
            List<String> artists = extractMultipleValues(item, "boardgameartist");

            Game game = new Game();
            game.setBggId(bggId);
            game.setTitle(title);
            game.setYear(year);
            game.setMinPlayers(minPlayers);
            game.setMaxPlayers(maxPlayers);
            game.setAge(age);
            game.setMinPlayTime(minPlayTime);
            game.setMaxPlayTime(maxPlayTime);
            game.setUrlImage(urlImage);
            game.setUrlThumbnail(urlThumbnail);
            game.setAuthors(authors);
            game.setArtists(artists);
            game.setType(item.getAttribute("type"));

            return game;
        }

        return null;
    }

    private Integer extractIntegerValue(Element item, String tagName) {
        NodeList nodes = item.getElementsByTagName(tagName);
        if (nodes.getLength() > 0) {
            return Integer.valueOf(((Element) nodes.item(0)).getAttribute("value"));
        }
        return null;
    }

    private String extractStringValue(Element item, String tagName) {
        NodeList nodes = item.getElementsByTagName(tagName);
        if (nodes.getLength() > 0) {
            return nodes.item(0).getTextContent();
        }
        return null;
    }

    private List<String> extractMultipleValues(Element item, String type) {
        NodeList nodes = item.getElementsByTagName("link");
        List<String> values = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            if (element.getAttribute("type").equals(type)) {
                values.add(element.getAttribute("value"));
            }
        }
        return values;
    }

}
