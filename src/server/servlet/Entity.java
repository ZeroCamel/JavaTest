package server.servlet;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-08-28 10:32
 **/
public class Entity {
    private String name;
    private String clz;

    public Entity() {
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
