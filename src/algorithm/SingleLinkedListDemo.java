package algorithm;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * 单链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(3);
        ListNode listNode8 = new ListNode(4);
        ListNode listNode9 = new ListNode(4);
        ListNode listNode10 = new ListNode(5);
        ListNode head = new ListNode(1, listNode1);
        listNode1.setNext(listNode2);
//        listNode2.setNext(listNode3);
//        listNode3.setNext(listNode4);
//        listNode4.setNext(listNode5);
//        listNode5.setNext(listNode6);
//        listNode6.setNext(listNode7);
//        listNode7.setNext(listNode8);
//        listNode8.setNext(listNode9);
//        listNode9.setNext(listNode10);


        ListNode delNode = deleteDuplicatesOpt(head);
    }

    /**
     * 删除单链表中的某个节点
     * 1、单链表不可以查找前驱指针
     * 2、将删除节点的数据域和指针域替换为下一个节点的数据域和指针域
     *
     * @param listNode
     */
    public void deleteNode(ListNode listNode) {
        listNode.val = listNode.next.val;
        listNode.next = listNode.next.next;

    }

    /**
     * 所有元素按照升序排列
     * 去除重复节点
     *
     * @param head
     */
    public ListNode distinctDuplicates(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }

    /**
     * 删除重复节点
     * 测试用例：重复元素分布 第一个 中间 单链表后面
     * 1 1 1 1 2 2 2 3 3 4 5 5
     * 1 1 1 2 2 3
     * 1 2 2 3
     * 思路：
     * 1、如果当前指针和后面的相同 则用第三个元素的数据域赋值第一个元素
     * 如果重复元素出现偶数词没有问题
     * 如果奇数次就无法全部去重
     * 2、
     * 问题：
     * 1、如果重复元素出现偶数次 则无法全部去除重复元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.val = p.next.next.val;
                p.next = p.next.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    /**
     * 删除重复节点 针对重复元素出现奇数次的情况
     * 核心测试用例：
     * [1,2,2,2,2,2,3,3,4,4,5]
     * [1,1]
     * []
     * [1,2,2]  ***
     * <p>
     * 问题：已删除节点置空问题 可以直接返回 Null
     * 重构一个新链表过滤重复元素
     *
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicatesOpt(ListNode head) {

        // 只有一个节点
        if (head != null && head.next == null) {
            return head;
        }

        // 只有两个节点
        if (head != null && head.next.next == null && head.val == head.next.val) {
            return null;
        }

        // 多个节点情况处理
        ListNode p = head;
        ListNode pre = head;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            if (q.val == p.val) {

                while (q.val == p.val && q.next != null) {
                    q = q.next;
                }

                if (q.val == p.val && q.next == null)
                {
                    if (pre.val == q.val)
                        return  null;
                    pre.next = null;
                    return head;
                }

                p.val = q.val;
                p.next = q.next;

            } else {
                pre = p;
                p = p.next;
            }
        }
        return head;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public void setNext(ListNode listNode) {
        this.next = listNode;
    }
}