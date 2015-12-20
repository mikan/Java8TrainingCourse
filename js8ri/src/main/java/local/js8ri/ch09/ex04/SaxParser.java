/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch09.ex04;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author mikan
 */
public class SaxParser {

    public static void main(String[] args) {
        SAXParser parser;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            return;
        }
        try {
            parser.parse(createSampleSource(), new SampleHandler());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class SampleHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            System.out.println("startDocument");
        }

        @Override
        public void endDocument() {
            System.out.println("endDocument");
        }

        @Override
        public void startElement(String namespaceURI, String localName, String qName, Attributes attrs) {
            System.out.println("\tstartElement: " + qName);
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qName) {
            System.out.println("\tendElement: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            StringBuilder builder = new StringBuilder("\t\tcharacters: ");
            for (int i = 0; i < length; i++) {
                builder.append(ch[start + i]);
            }
            System.out.println(builder.toString());
        }
    }

    private static InputStream createSampleSource() {
        return new ByteArrayInputStream((
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><root><data>あいうえお</data></root>")
                .getBytes());
    }
}
