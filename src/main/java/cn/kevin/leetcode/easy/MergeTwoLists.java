package cn.kevin.leetcode.easy;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Personal Note:
 * I don't get the exact meaning. So I did this like [1,2,3] and [4,5,6] would produce [1,4,2,5,3,6]
 * Algorithm is not easy to me, still need more to work on.
 * created by yongkang.zhang
 * added at 2017/9/11
 */
public class MergeTwoLists {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode a = l1;
        ListNode b = l2;
        ListNode curNode = result;
        while (a != null && b != null) {
            curNode.setNext(a);
            curNode = curNode.getNext();
            a = a.getNext();

            curNode.setNext(b);
            curNode = curNode.getNext();
            b = b.getNext();
        }

        if (a != null) {
            curNode.setNext(a);
        }

        if (b != null) {
            curNode.setNext(b);
        }

        return result.getNext();
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(5);
        ListNode b3 = new ListNode(6);
        a1.setNext(a2);
        a2.setNext(a3);
        b1.setNext(b2);
        b2.setNext(b3);
        ListNode listNode = mergeTwoLists(a1, b1);
        while (listNode != null) {
            System.out.println(listNode.getVal());
            listNode = listNode.getNext();
        }
    }

}

class ListNode {
      private int val;
      private ListNode next;
      ListNode(int x) { this.val = x; }
      ListNode getNext() {
          return this.next;
      }
      void setNext(ListNode node) { this.next = node; }
      int getVal() { return this.val; }

}