package com.ukr.net.crawler.data.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.ukr.net.crawler.data.service.Connector;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
@Configuration
public class LinksConfig {

    private final Environment env;
    
    @Bean
    public Map<String, StringBuilder> linksOfTopics() throws IOException {

        Document doc = Connector.connectURLAndReturnReadContext(env.getProperty("ain-main"));

        Elements titles = doc.select("div.block-title");

        Elements links = new Elements();
        for (Element title : titles) {
            links.add(title.getElementsByAttribute("href").first());
        }
        links.remove(0);
        links.remove(0);

        Map<String, StringBuilder> mapTitleToLink = new HashMap<>();
        for (Element link : links) {
            mapTitleToLink.put(link.text(), new StringBuilder(link.attr("href")).insert(0, env.getProperty("ain-main")));
        }
        
        return mapTitleToLink;
    }
}
