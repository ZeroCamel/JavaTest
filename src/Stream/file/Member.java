package Stream.file;

import java.io.*;

/**
 * @program: JavaTest
 * @description: ${DataInputStream DataOutputStream}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-16 23:03
 **/
public class Member {
    private String number;
    private String name;
    private int age;

    public Member(String number, String name, int age)
    {
        this.number=number;
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)",number,name,age);
    }

    public void Save() throws IOException {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(number))) {
            output.writeUTF(number);
            output.writeUTF(name);
            output.writeInt(age);
        }
    }

    public static Member load(String number)
    {
        Member member = null;
        try(DataInputStream input =
                new DataInputStream(new FileInputStream(number))) {

            member = new Member(input.readUTF(),input.readUTF(),input.readInt());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  member;
    }

}
