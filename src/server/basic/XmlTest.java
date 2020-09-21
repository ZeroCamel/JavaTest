package server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
        InputStream inputStream = new FileInputStream("src/Server/basic/p.xml");
        //saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p.xml"), pHandler);
        saxParser.parse(inputStream, pHandler);

        // 输出Person
        List<Person> persons = pHandler.getPersons();
        for (Person p :persons)
        {
            System.out.println(p);
        }

    }
}

class PHandler extends DefaultHandler {

    private List<Person> persons;
    private Person person;

    /**
     * 存储操作的标签
     */
    private String tag;

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析文档开始...");
        persons = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "-->解析开始");
        if (null != qName) {
            tag = qName;
            String comStr = "person";
            if (tag.equals(comStr)) {
                person = new Person();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String trim = new String(ch, start, length).trim();
        if (trim.length() > 0) {
            System.out.println(tag+"内容为-->" + trim);
        } else {
            System.out.println(tag+"内容为-->" + "空");
        }

        if (null!=tag)
        {
            String nodeName = "name";
            String nodeAge = "age";
            if (tag.equals(nodeName)) {
                person.setName(trim);
            } else if (tag.equals(nodeAge)) {
                if (trim.length() > 0) {
                    person.setAge(Integer.valueOf(trim));
                }
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "-->解析结束");
        if (null != qName) {
            String nodePerson = "person";
            if (qName.equals(nodePerson)) {
                persons.add(person);
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析文档结束...");
    }
}
