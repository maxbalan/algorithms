package linkedlist;

import linkedlist.util.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Date: 3/17/22
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * <p>
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 **/
public class MergeAllSortedListsV2 {

    public static void main(String[] args) {
        var i = new MergeAllSortedListsV2();
        var l = new ListNode(1, new ListNode(4, new ListNode(5)));
        var l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        var l3 = new ListNode(2, new ListNode(6));
        System.out.printf("RESPONSE: %s%n", i.solution(new ListNode[]{l, l2, l3}));
//        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{2,2,2,2,2}, 8));
    }

    public ListNode solution(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        var stack = new Stack<ListNode>();
        stack.addAll(Arrays.asList(lists));

        if (stack.isEmpty()) {
            return null;
        }

        ListNode result = null;
        while (stack.size() > 1) {
            result = merge(stack.pop(), stack.pop());
            stack.add(result);
        }

        return stack.pop();
    }

    public ListNode merge(ListNode list1, ListNode list2) {
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
