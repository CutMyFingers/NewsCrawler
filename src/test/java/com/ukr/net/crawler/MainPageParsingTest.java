package com.ukr.net.crawler;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import com.ukr.net.crawler.data.service.Connector;

public class MainPageParsingTest {

    @Test
    public void jsonParserTest() throws IOException {

        Document doc = Connector.connectURLAndReturnReadContext("https://ain.ua");

        Elements titles = doc.select("div.block-title");

        Elements links = new Elements();
        for (Element title : titles) {
            links.add(title.getElementsByAttribute("href").first());
        }
        links.remove(0);
        links.remove(0);

        Map<String, StringBuilder> mapTitleToLink = new HashMap<>();
        for (Element link : links) {
            mapTitleToLink.put(link.text(), new StringBuilder(link.attr("href")).insert(0, "https://ain.ua"));
        }

        StringBuilder pageLink = mapTitleToLink.get("Государство");
        
        doc = Connector.connectURLAndReturnReadContext(pageLink.insert(pageLink.length(), "/page/" + 3 + "/").toString());
        

        assertThat("");
    }

}
