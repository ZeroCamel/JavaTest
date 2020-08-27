package Server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @program: JavaTest
 * @description: Xml解析器
 * @author: zeroCamel
 * @create: 2020-08-27 16:25
 **/
public class XmlTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // SAX文件解析 流解析
        // 获取解析工厂
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        // 从解析工厂获取解析器
        SAXParser saxParser = saxParserFactory.newSAXParser();
        // 编写处理器
        PHandler pHandler = new PHandler();
        // 解析
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p.xml"),pHandler);

    }
}

class PHandler extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析文档开始...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"-->解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String trim = new String(ch, start, length).trim();
        if (trim.length()>0)
        {
            System.out.println("内容为-->"+trim);
        } else {
            System.out.println("内容为-->"+"空");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"-->解析结束");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析文档结束...");
    }
}
