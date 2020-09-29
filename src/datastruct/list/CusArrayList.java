package datastruct.list;

import java.util.Arrays;

/**
 * @program: JavaTest
 * @description: 自定义ArrayList
 * @author: zeroCamel
 * @create: 2020-09-29 10:26
 **/
public class CusArrayList<E> {
    private Object[] elementData;
    private int length = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public CusArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public CusArrayList(int size) {
        elementData = new Object[size];
    }

    public void add(E value) {
        // 扩容
        if (length == elementData.length) {
            // 准备新空间 注意运算的优先级
            Object[] newObject = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newObject, 0, elementData.length);
            elementData = newObject;
        }
        elementData[length++] = value;
    }

    public void remove(int index) {
        int numMoved = elementData.length - index - 1;
        if (numMoved > 0)
        {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--length] = null;
    }

    public void remove(E element) {
        for (int i = 0; i < length; i++) {
            if (element.equals(get(i))) {
                remove(i);
            }
        }
    }

    public E get(int index) {
        checkRange(index);
        return (E) elementData[index];
    }

    public void set(E element, int index) {
        checkRange(index);
        elementData[index] = element;
    }

    public void checkRange(int index) {
        if (index < 0 || index > length - 1) {
            throw new RuntimeException("索引不合法：" + index);
        }
    }

    @Override
    public String toString() {
        return "CusArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        CusArrayList<String> cusArrayList = new CusArrayList();
        cusArrayList.add("11");
        cusArrayList.add("22");
        cusArrayList.add("33");


        int a = 5;
        int b = 4;
        int c = a++ - --b * ++a / b-- >> 2 % a--;
        System.out.println(c);

        System.out.println(a++);

        System.out.println(cusArrayList);
    }
}
