package CollectionAndMap;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-04 21:27
 **/
public class Student {
    private String Name;
    private String Number;
    public Student(String name,String number)
    {
        this.Name = name;
        this.Number = number;
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
        hash = 13*hash+(this.Name!=null?this.Name.hashCode():0);
        hash = 13*hash+(this.Number!=null?this.Number.hashCode():0);
        return hash;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)",this.Name,this.Number);
    }
}
