package Server.servlet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
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
    public static void main(String[] args) throws Exception {
        // SAX文件解析 流解析
        // 获取解析工厂
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        // 从解析工厂获取解析器
        SAXParser saxParser = saxParserFactory.newSAXParser();
        // 编写处理器
        WebHandler pHandler = new WebHandler();
        // 解析
        InputStream inputStream = new FileInputStream("src/Server/servlet/web.xml");
        //saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p.xml"), pHandler);
        saxParser.parse(inputStream, pHandler);

        // 输出上下文
        WebContext webContext = new WebContext(pHandler.getEntities(), pHandler.getMappings());
        String clz = webContext.getClz("/l");
        Class<?> aClass = Class.forName(clz);
        MyServlet o = (MyServlet) aClass.getConstructor().newInstance();
        System.out.println(o);
        o.service();
    }
}

class WebHandler extends DefaultHandler {

    private List<Entity> entities;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;

    /**
     * 存储操作的标签
     */
    private String tag;
    private boolean isMapping = false;

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析文档开始...");
        mappings = new ArrayList<>();
        entities = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "-->解析开始");
        if (null != qName) {
            tag = qName;
            if (tag.equals("servlet")) {
                entity = new Entity();
                isMapping = false;
            } else if (tag.equals("servlet-mapping")) {
                mapping = new Mapping();
                isMapping = true;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (null != tag) {

            if (isMapping) {
                if (tag.equals("servlet-name")) {
                    mapping.setName(contents);
                } else if (tag.equals("url-pattern")) {
                    mapping.addPattern(contents);
                }

            } else {
                if (tag.equals("servlet-name")) {
                    entity.setName(contents);
                } else if (tag.equals("servlet-class")) {
                    entity.setClz(contents);
                }
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "-->解析结束");
        if (qName.equals("servlet")) {
            entities.add(entity);
        } else if (qName.equals("servlet-mapping")) {
            mappings.add(mapping);
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析文档结束...");
    }
}
