package linkedlist;

import linkedlist.util.LinkedListNode;
import linkedlist.util.LinkedListUtils;

/**
 * 30/10/18
 * <p>
 * Question:
 * Implement an algorithm to find the Kth to last element of a singly linked list
 * <p>
 * k = 1 = last element
 * k = 2 will return 2nd to last element
 * <p>
 * <p>
 * Solution 1:
 * For this solution we gonna use a recursive call, so iterate through the list till we reach the last element and start
 * counting back until we hit the Kth element and print it.
 * <p>
 * Its a nice and simple solution though we don't have a way to return the Node back, unless we have a global variable to
 * assign it to and in many cases this is not a viable solution.
 * <p>
 * time: O(N) where N is the number of nodes in the list
 * space: O(N) where N is the number of nodes in the list
 * <p>
 * <p>
 * Solution 2:
 * compared to 1st solution this one returns the actual node, and is implemented using 2 pointers, S -> points to head of
 * the list and F -> is placed k spaces away from S, so iterating through the list when F hits the end then S is kth elements
 * away from the last element and we can return it
 * <p>
 * time: O(N) where N is the number of nodes in the list
 * space: O(1)
 *
 * @author Maxim Balan
 **/
public class KthElementToLastV2 {

    public static void main(String[] args) {
        LinkedListNode<Integer> ll = LinkedListUtils.generateIntegerLinkedList(1, 11);

        int k = 2;
        LinkedListNode<Integer> kth = returnKthToLastNode(ll, k);

        System.out.println(ll);
        System.out.println(String.format("%dth element to last is [ %d ]", k, kth.getValue()));
    }

    private static LinkedListNode<Integer> returnKthToLastNode(LinkedListNode<Integer> ll, int k) {
        LinkedListNode<Integer> s = ll;
        LinkedListNode<Integer> f = ll;

        //place F k nodes away from S
        for (int i = 0; i < k; i++) {
            if (f.getNext() != null)
                f = f.getNext();
            else
                throw new RuntimeException("List length is less then searched index");
        }

        while (f != null) {
            f = f.getNext();
            s = s.getNext();
        }

        return s;
    }

}
