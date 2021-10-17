package designpattern.create.simplefactory;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-17 21:20
 **/
public class CourseFactory {

    public static ICourse createOld(String courseName) {
        try {
            if (!(null == courseName || "".equals(courseName))) {
                return (ICourse) Class.forName(courseName).newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将方法参数改为泛型类型
     * @param clazz
     * @return
     */
    public static ICourse create(Class<? extends ICourse> clazz) {

        try {
            if (clazz != null) {
                return clazz.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }
}
