package datastruct.map;

/**
 * @program: JavaTest
 * @description: 自定义map实现
 * @author: zeroCamel
 * @create: 2020-09-28 11:38
 **/
public class CusHashMap {
    /**
     * 位桶数组
     */
    private Node[] table;

    /**
     * 键值对个数
     */
    private int size;

    /**
     * 装载因子
     */
    private double LOAD_FACTOR = 0.75d;

    public CusHashMap() {

        // 长度为2的整数次幂
        table = new Node[16];
    }

    public void ensureCapacity()
    {

    }

    public void put(Object key, Object value) {

        // 数组扩容
        ensureCapacity();

        Node newNode = new Node();
        newNode.hashCode = getHashCode(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node temp = table[newNode.hashCode];
        if (null == temp) {
            table[newNode.hashCode] = newNode;
            size++;
        } else {

            // 保存是最后一个节点的引用
            Node iterLast = null;

            // 判断是否重复
            boolean keyRepeat = false;

            // 遍历插入
            while (temp != null) {
                if (temp.key.equals(key)) {
                    keyRepeat = true;
                    temp.value = value;
                    break;
                } else {
                    iterLast = temp;
                    temp = temp.next;
                }
            }

            // 重复链接引用
            if (!keyRepeat) {
                iterLast.next = newNode;
                size++;
            }
        }

    }

    public Object get(Object key) {
        int keyLocate = getHashCode(key.hashCode(), table.length);

        Object value = null;

        if (table[keyLocate] != null) {
            Node temp = table[keyLocate];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    value = temp.value;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < table.length; i++) {
            Node temp = table[i];
            while (temp != null) {
                stringBuilder.append(temp.key + ":" + temp.value + ".");
                temp = temp.next;
            }
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, '}');

        return stringBuilder.toString();
    }

    private int getHashCode(int key, int length) {
        return key & (length - 1);
    }

}
