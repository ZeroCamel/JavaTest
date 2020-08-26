package ScriptEngine;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @program: JavaTest
 * @description: 测试脚本引擎
 * @author: zeroCamel
 * @create: 2020-08-26 10:14
 **/
public class Demo01 {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine javascript = scriptEngineManager.getEngineByName("javascript");

        javascript.put("msg", "test javascirptengine");
        String str = "var a=1;";
        str += "print(a)";

        // 执行脚本
        javascript.eval(str);
        javascript.eval("msg='hhhh'");
        System.out.println(javascript.get("msg"));
        System.out.println(javascript.get("a"));

        // 定义函数
        javascript.eval("function add(a,b){var sum=a+b;return sum;}");
        // 执行函数
        Invocable javascript1 = (Invocable) javascript;
        Object add = ((Invocable) javascript).invokeFunction("add", new Object[]{12, 19});
        System.out.println(add);

        String jsCode = "var list = java.util.Arrays.asList(['a','b','c'])";
        javascript.eval(jsCode);

        List<String> lst = (List<String>) javascript.get("list");
        for (String temp:lst)
        {
            System.out.println(temp);
        }

        // 执行js文件
        URL resource = Demo01.class.getClassLoader().getResource("a.js");
        FileReader fileReader = null;
        try {

            fileReader = new FileReader(resource.getPath());
            javascript.eval(fileReader);
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
