package linkedlist;

import linkedlist.util.ListNode;

/**
 * Date: 3/17/22
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * @author Maxim Balan
 **/
public class RemoveNthElementFromTheEndOfLinkedList {

    public static void main(String[] args) {
        var i = new RemoveNthElementFromTheEndOfLinkedList();
        var l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        var l = new ListNode(1);
        System.out.printf("RESPONSE: %s%n", i.solution(l, 3));
//        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{2,2,2,2,2}, 8));
    }

    public ListNode solution(ListNode head, int n) {
        int size = 0;
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            size++;
            current = current.next;
        }

        if (size == n) {
            return head.next;
        }

        int removeIndex = size - n;
        current = head;
        int i = 0;
        while (i < removeIndex) {
            prev = current;
            current = current.next;
            i++;
        }

        prev.next = current.next;

        return head;
    }
}
