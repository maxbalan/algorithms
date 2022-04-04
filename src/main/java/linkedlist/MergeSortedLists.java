package linkedlist;

import linkedlist.util.ListNode;

/**
 * Date: 3/17/22
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * @author Maxim Balan
 **/
public class MergeSortedLists {

    public static void main(String[] args) {
        var i = new MergeSortedLists();
        var l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        var l2 = new ListNode(1);
        System.out.printf("RESPONSE: %s%n", i.solution(l, l2));
//        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{2,2,2,2,2}, 8));
    }

    public ListNode solution(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode r = new ListNode();
        var result = r;
        var a = list1;
        var b = list2;

        while (a != null && b != null) {
            if (a.val > b.val) {
                r.next = new ListNode(b.val);
                r = r.next;
                b = b.next;
            } else if (a.val < b.val) {
                r.next = new ListNode(a.val);
                r = r.next;
                a = a.next;
            } else {
                r.next = new ListNode(a.val);
                r = r.next;
                r.next = new ListNode(b.val);
                r = r.next;
                a = a.next;
                b = b.next;
            }
        }

        if (a != null) {
            r.next = a;
        } else if (b != null) {
            r.next = b;
        }

        return result.next;
    }
}
