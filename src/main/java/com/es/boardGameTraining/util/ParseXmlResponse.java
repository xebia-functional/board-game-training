package com.es.boardGameTraining.util;

import com.es.boardGameTraining.dto.GameBggDTO;
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
    public List<GameBggDTO> parseXmlResponseGame(String xml) throws Exception {
        List<GameBggDTO> games = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xml)));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        NodeList items = (NodeList) xpath.evaluate("/items/item", document, XPathConstants.NODESET);

        for (int i = 0; i < items.getLength(); i++) {
            Element item = (Element) items.item(i);
            String id = item.getAttribute("id");
            String title = ((Element) item.getElementsByTagName("name").item(0)).getAttribute("value");

            NodeList yearNodes = item.getElementsByTagName("yearpublished");
            String year = (yearNodes.getLength() > 0) ? ((Element) yearNodes.item(0)).getAttribute("value") : null;

            GameBggDTO game = new GameBggDTO();
            game.setId(Long.valueOf(id));
            game.setName(title);

            game.setYearPublished(year != null ? Integer.valueOf(year) : null);

            games.add(game);
        }


        return games;
    }
}
