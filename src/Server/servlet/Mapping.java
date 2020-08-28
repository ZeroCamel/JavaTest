package Server.servlet;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-08-28 10:34
 **/
public class Mapping {
    private String name;
    private Set<String> patterns;

    public Mapping() {
        patterns = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }

    public void addPattern(String pattern)
    {
        this.patterns.add(pattern);
    }
}
