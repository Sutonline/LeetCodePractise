package cn.kevin.leetcode.easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * created by yongkang.zhang
 * added at 2017/9/14
 */
public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode nextNode;
        ListNode root = new ListNode(0);
        root.setNext(head);
        while (head.getNext() != null) {
            nextNode = head.getNext();
            if (head.getVal() == nextNode.getVal()) {
                head.setNext(nextNode.getNext());
            }
            head = head.getNext();
        }

        return root.getNext();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        ListNode listNode = deleteDuplicates(node1);
        while(listNode != null) {
            System.out.println("值是: " + listNode.getVal());
            listNode = listNode.getNext();
        }
    }
}
