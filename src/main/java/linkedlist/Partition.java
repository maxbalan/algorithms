package linkedlist;

import linkedlist.util.LinkedListNode;
import linkedlist.util.LinkedListUtils;

/**
 * 31/10/18
 * <p>
 * Question:
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x . lf x is contained within the list, the values of x only need
 * to be after the elements less than x (see below) . The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * <p>
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * <p>
 * <p>
 * Solution 1:
 * so in order to be able to sort the list this way we will need to start with 2 lists one for the left values and other
 * for the right ones, everything less then X should go into left list and everything else into the right one also we
 * need to links the the head of each list so we can merge them together and return the result
 **/
public class Partition {

    public static void main(String[] args) {
        LinkedListNode<Integer> ll = LinkedListUtils.generateRandomIntegerLinkedList(1, 10, 10);

        System.out.println("NotPartitioned: " + ll);

        int a = ll.getNext().getValue();

        System.out.println("partition by: " + a);

        LinkedListNode<Integer> p = partition(ll, a);

        System.out.println(p);
    }

    private static LinkedListNode<Integer> partition(LinkedListNode<Integer> ll, int partitionBy) {
        LinkedListNode<Integer> left = new LinkedListNode<>(0);
        LinkedListNode<Integer> right = new LinkedListNode<>(0);
        LinkedListNode<Integer> x = ll;
        LinkedListNode<Integer> lh = left;
        LinkedListNode<Integer> rh = right;


        while (x != null) {
            if (x.getValue() < partitionBy) {
                left.setNext(new LinkedListNode<>(x.getValue()));
                left = left.getNext();
            } else {
                right.setNext(new LinkedListNode<>(x.getValue()));
                right = right.getNext();
            }

            x = x.getNext();
        }

        left.setNext(rh.getNext());

        return lh.getNext();
    }

}
