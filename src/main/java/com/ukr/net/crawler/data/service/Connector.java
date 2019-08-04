package com.ukr.net.crawler.data.service;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Connector {

    public static Document connectURLAndReturnReadContext(String connectionURL) throws IOException {
        Response response = Jsoup.connect(connectionURL)
            .ignoreContentType(true)
            .userAgent("Mozilla/5.0 (Windows; U; Windows NT 6.1; rv:2.2) Gecko/20110201")
            .referrer("http://www.google.com")
            .timeout(12000)
            .followRedirects(true)
            .execute();

        if (response.statusCode() == 200)
            return response.parse();
        return null;
    }
}
