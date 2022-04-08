package linkedlist;

import linkedlist.util.ListNode;

/**
 * Date: 3/17/22
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * <p>
 * Example 2:
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1]
 * Output: [1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 **/
public class SwapPairs {

    public static void main(String[] args) {
        var i = new SwapPairs();
        var l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        var l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        var l3 = new ListNode(2, new ListNode(6));
        System.out.printf("RESPONSE: %s%n", i.solution(l));
//        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{2,2,2,2,2}, 8));
    }

    public ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }

        var start = head.next;
        if (start == null) {
            return head;
        }

        var current = head;
        ListNode last = null;
        while (current != null && current.next != null) {
            var a = current;
            var b = a.next;
//            var bNext = b.next;

            a.next = b.next;
            b.next = a;

            if (last != null) {
                last.next = b;
            }

            last = a;
            current = a.next;
        }

        return start;
    }
}
