package linkedlist;

import linkedlist.util.ListNode;

import java.util.ArrayDeque;

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
public class MergeAllSortedLists {

    public static void main(String[] args) {
        var i = new MergeAllSortedLists();
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

        var stack = new ArrayDeque<ListNode>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                stack.add(lists[i]);
            }
        }

        if (stack.isEmpty()) {
            return null;
        }

        ListNode r = new ListNode();
        var result = r;

        var current = stack.pop();
        while (stack.size() > 0) {

            for (int i = 0; i < stack.size(); i++) {
                var l = stack.pop();
                if (l.val > current.val) {
                    stack.addLast(l);
                    continue;
                } else {
                    stack.addLast(current);
                    current = l;
                }
            }

            r.next = new ListNode(current.val);
            r = r.next;
            if (current.next != null) {
                current = current.next;
            } else {
                current = stack.pop();
            }
        }

        r.next = current;
        return result.next;
    }
}
