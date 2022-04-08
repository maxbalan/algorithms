package linkedlist;

import linkedlist.util.ListNode;

/**
 * Date: 3/17/22
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 **/
public class SwapKGroupElements {

    public static void main(String[] args) {
        var i = new SwapKGroupElements();
        var l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        var l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        var l3 = new ListNode(2, new ListNode(6));
        System.out.printf("RESPONSE: %s%n", i.solution(l, 2));
//        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{2,2,2,2,2}, 8));
    }

    public ListNode solution(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        var start = new ListNode(0, head);
        var groupPrev = start;

        var kth = getKthNode(groupPrev, k);
        while (kth != null) {
            var groupNext = kth.next;
            var prev = kth.next;
            var curr = groupPrev.next;

            while (curr != groupNext) {
                var tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            var tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
            kth = getKthNode(groupPrev, k);
        }

        return start.next;
    }

    public ListNode getKthNode(ListNode n, int k) {
        while (n != null && k > 0) {
            n = n.next;
            k--;
        }

        return n;
    }
}
