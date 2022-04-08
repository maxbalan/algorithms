package linkedlist;

import linkedlist.util.ListNode;

public class SwapFirstKElements {

    public static void main(String[] args) {
        var i = new SwapFirstKElements();
        var l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        var l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        var l3 = new ListNode(2, new ListNode(6));
        System.out.printf("RESPONSE: %s%n", i.solution(l, 3));
//        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{2,2,2,2,2}, 8));
    }

    public ListNode solution(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        var start = head;
        var r = head;

        int i = k - 1;
        while (i > 0) {
            start = r;
            r = r.next;
            swapK(start, start.next, null, i);
            i--;
        }

        return r;
    }

    public void swapK(ListNode a, ListNode b, ListNode link, int remain) {
        if (remain == 0) {
            return;
        }

        a.next = b.next;
        b.next = a;
        //        return;

        if (link != null) {
            link.next = b;
        }

        link = b;

        swapK(a, a.next, link, remain - 1);
    }
}
