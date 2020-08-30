package Server.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: JavaTest
 * @description: ${XML文件上下文}
 * @author: Mr.ZeroCamel
 * @create: 2020-08-29 18:06
 **/
public class WebContext {

    private Map<String, String> classMapping = new HashMap<>();
    private Map<String, String> urlMapping = new HashMap<>();

    private List<Entity> lstEnity = null;
    private List<Mapping> lstMapping = null;

    public WebContext(List<Entity> lstEnity, List<Mapping> lstMapping) {

        this.lstEnity = lstEnity;
        this.lstMapping = lstMapping;

        listToMap();
    }

    /**
     * 将线性关系转为Map
     */
    public void listToMap() {
        for (Entity entity : lstEnity) {
            classMapping.put(entity.getName(), entity.getClz());
        }

        for (Mapping mapping : lstMapping) {
            for (String url : mapping.getPatterns()) {
                urlMapping.put(url, mapping.getName());
            }
        }
    }


    /**
     * 通过路由寻找指定类
     *
     * @param pattern
     * @return
     */
    public String getClz(String pattern) {
        String s = urlMapping.get(pattern);
        String s1 = classMapping.get(s);
        return s1;
    }
}
