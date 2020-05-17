package Stream;

import java.io.*;

/**
 * @program: JavaTest
 * @description: ${ObjectInputStream ObjectOutputStream}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-16 23:17
 **/
public class MemberSeria implements Serializable {
    private String number;
    private String name;
    private int age;

    public MemberSeria(String number,String name,int age)
    {
        this.number=number;
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString()
    {
        return String.format("(%s,%s,%s)",number,name,age);
    }

    public void Save()
    {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(number))) {
            output.writeObject(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MemberSeria Load(String number)
    {
        MemberSeria member = null;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(number))){
            member = (MemberSeria) input.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return member;
    }
}
