package Annotation;

/**
 * @program: JavaTest
 * @description:
 * @author: zeroCamel
 * @create: 2020-08-25 16:11
 **/
@TableNameAnno(value = "tb_student")
public  class Student{
    @TableFieldAnno(columnName = "id",type = "int",length = 10)
    private Integer id;
    @TableFieldAnno(columnName = "sname",type = "varchar",length = 10)
    private String studentName;
    @TableFieldAnno(columnName = "age",type = "int",length = 3)
    private Integer age;

    // 反射 必须添加无参构造器 否则报错
    public Student() {
    }

    public Student(Integer id, String studentName, Integer age) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
