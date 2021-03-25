package algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 删除单链表中的某个节点
 * 1、单链表不可以查找前驱指针
 * 2、将删除节点的数据域和指针域替换为下一个节点的数据域和指针域
 */
public class deleteNode {
    public static void main(String[] args) {

    }

    public void deleteNode(ListNode listNode) {
        listNode.val = listNode.next.val;
        listNode.next = listNode.next.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}