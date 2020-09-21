package collectionandmap;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-04 21:27
 **/
public class Student {
    private String name;
    private String number;
    public Student(String name,String number)
    {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object object)
    {
        if (object == null)
        {
            return false;
        }

        if (getClass()!=object.getClass())
        {
            return false;
        }
        final Student other = (Student) object;
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 13*hash+(this.name!=null?this.name.hashCode():0);
        hash = 13*hash+(this.number!=null?this.number.hashCode():0);
        return hash;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)",this.name,this.number);
    }
}
