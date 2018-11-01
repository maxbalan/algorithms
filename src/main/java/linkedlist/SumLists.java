package linkedlist;

/**
 * 01/11/18
 * <p>
 * Question:
 * You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input: (7 -> 1 -> 6 -> 5 -> 9 -> 2) .That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * <p>
 * EXTRA
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * <p>
 * EXAMPLE
 * Input: (6 -> 1 -> 7 -> 2 -> 9 -> 5) . That is, 617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912
 * <p>
 * <p>
 * Solution:
 * in first place we have to assume that the lists are not the same length, so we take each value from the string we sum
 * it and check if there is a carry over value if yes then we set it in the next node to be used in the next calculation
 * <p>
 * TIME: O(N) where N is the length of the longest list form the 2 provided
 * <p>
 * <p>
 * Solution EXTRA:
 * as for the initial solution we will assume that the lists are not the same lengths (this adds extra stuff but for the
 * sake of this exercise and practice I will assume it) so as the order of the number is not inverted now we have to
 * equalize the lists by adding ZEROs at the head of the shorter list, so to be able to do this we need to calculate the
 * length of each list in order to be able to calculate the threshold for the shortest list, then as the solution is a
 * recursive call we subtract 1 for each call until it reaches 0 or less then we start actually taking nodes out of the
 * list so when we reach the end of the longer list we actually reach the end of the shortest list too. After that on each
 * return we start calculating the current number and setting the carry over in the head of the result list.
 *
 * @author Maxim Balan
 **/
public class SumLists {

    public static void main(String[] args) {
        LinkedListNode<Integer> ll1 = LinkedListUtils.generateIntegerLinkedList(1, 4);
        LinkedListNode<Integer> ll2 = LinkedListUtils.generateIntegerLinkedList(5, 8);

        System.out.println(ll1);
        System.out.println(ll2);

        LinkedListNode<Integer> r = sumLists(ll1, ll2);
        System.out.println("Result: " + r + "\n\n");

        // lets test with lists of different lengths
        ll1 = LinkedListUtils.generateIntegerLinkedList(1, 4);
        ll2 = LinkedListUtils.generateIntegerLinkedList(5, 10);

        System.out.println(ll1);
        System.out.println(ll2);

        r = sumLists(ll1, ll2);
        System.out.println("Result: " + r + "\n\n");


        // lets test the EXTRA part
        ll1 = LinkedListUtils.generateIntegerLinkedList(1, 4);
        ll2 = LinkedListUtils.generateIntegerLinkedList(5, 8);

        System.out.println(ll1);
        System.out.println(ll2);

        r = sumListsExtra(ll1, ll2);
        System.out.println("EXTRA Result: " + r + "\n\n");

        // lets test with lists of different lengths
        ll1 = LinkedListUtils.generateIntegerLinkedList(1, 4);
        ll2 = LinkedListUtils.generateIntegerLinkedList(5, 10);

        System.out.println(ll1);
        System.out.println(ll2);

        r = sumListsExtra(ll1, ll2);
        System.out.println("EXTRA Result: " + r + "\n\n");
    }

    private static LinkedListNode<Integer> sumLists(LinkedListNode<Integer> a, LinkedListNode<Integer> b) {
        LinkedListNode<Integer> result = new LinkedListNode<>(0);
        LinkedListNode<Integer> rh = result;

        while (a != null || b != null) {
            int m = a != null ? a.getValue() : 0;
            int n = b != null ? b.getValue() : 0;
            int carry = result.getNext() != null ? result.getNext().getValue() : 0;

            int x = m + n + carry;

            //carry over
            if (x / 10 > 0) {
                result.setNext(new LinkedListNode<>(x % 10));
                result.getNext().setNext(new LinkedListNode<>(x / 10));
            } else
                result.setNext(new LinkedListNode<>(x));

            result = result.getNext();

            b = b != null ? b.getNext() : b;
            a = a != null ? a.getNext() : a;
        }

        return rh.getNext();
    }

    private static LinkedListNode<Integer> sumListsExtra(LinkedListNode<Integer> a, LinkedListNode<Integer> b) {
        int x = calculateLength(a);
        int y = calculateLength(b);
        int aTh = 0;
        int bTh = 0;

        if (x > y) bTh = x - y;
        else if (x < y) aTh = y - x;

        return sumListFromTail(a, b, aTh, bTh).getNext();
    }

    private static LinkedListNode<Integer> sumListFromTail(LinkedListNode<Integer> a,
                                                           LinkedListNode<Integer> b,
                                                           int aTh,
                                                           int bTh) {
        if (a == null && b == null) return new LinkedListNode<>(0);

        int x = aTh > 0 ? 0 : a.getValue();
        int y = bTh > 0 ? 0 : b.getValue();

        b = (b != null) && (bTh <= 0) ? b.getNext() : b;
        a = (a != null) && (aTh <= 0) ? a.getNext() : a;

        LinkedListNode<Integer> r = sumListFromTail(a, b, aTh - 1, bTh - 1);
        int sum = x + y + r.getValue();

        r.setValue(sum % 10);


        if (sum >= 10)
            r = new LinkedListNode<>(sum / 10).setNext(r);
        else
            r = new LinkedListNode<>(0).setNext(r);

        return r;
    }

    private static int calculateLength(LinkedListNode<Integer> x) {
        LinkedListNode<Integer> a = x;
        int i = 0;

        while (a != null) {
            i++;
            a = a.getNext();
        }

        return i;
    }

}
