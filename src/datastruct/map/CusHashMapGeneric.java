package datastruct.map;

/**
 * @program: JavaTest
 * @description: 自定义map实现
 * @author: zeroCamel
 * @create: 2020-09-28 11:38
 **/
public class CusHashMapGeneric<K,V> {
    /**
     * 位桶数组
     */
    private NodeGeneric[] table;

    /**
     * 键值对个数
     */
    private int size;

    public CusHashMapGeneric() {

        // 长度为2的整数次幂
        table = new NodeGeneric[16];
    }

    public void put(K key, V value) {

        // 如果完善还需要数组扩容

        NodeGeneric newNode = new NodeGeneric();
        newNode.hashCode = getHashCode(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        NodeGeneric temp = table[newNode.hashCode];
        if (null == temp) {
            table[newNode.hashCode] = newNode;
            size++;
        } else {

            // 保存是最后一个节点的引用
            NodeGeneric iterLast = null;

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

    public V get(K key) {
        int keyLocate = getHashCode(key.hashCode(), table.length);

        V value = null;

        if (table[keyLocate] != null) {
            NodeGeneric temp = table[keyLocate];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    value = (V) temp.value;
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
            NodeGeneric temp = table[i];
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
