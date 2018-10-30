package linkedlist;

import java.util.HashSet;
import java.util.Set;

import javax.sound.sampled.Line;

/**
 * 30/10/18
 *
 * Question:
 * Write a code to remove duplicates from an unsorted linked list
 *
 * EXTRA:
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 *
 * Solution with buffer:
 * we are going to create a hash table and put all values in there as we go through the linked list also we have a previous
 * node pointer which always points to the last unique node, if we find a duplicate then we prev.next is set to the next
 * node of the duplicated node so we can skip it, if there are no duplicates then replace the previous pointer with current
 * value and get the next node.
 *
 * the Big-O if O(N) where N is the number of elements in the linked list
 *
 *
 * Solution with no buffer:
 * the idea in this case is to iterate for each value trough the rest of the linked list, it sacrifices the time though
 *
 * the Big-O is O(N^2)  where N is the number of elements in the linked list and the space complexity is O(1)
 *
 *
 * @author Maxim Balan
 **/
public class RemoveDuplicates {

    public static void main(String[] args) {
        LinkedListNode<Integer> ll = LinkedListUtils.insertIntegers(1, 100);

        //insert some duplicates
        LinkedListUtils.insertIntegers(50, 60, ll);

        removeDuplicatesWithBuffer(ll);

        System.out.println(ll);


        LinkedListNode<Integer> ll2 = LinkedListUtils.insertIntegers(1, 100);

        //insert some duplicates
        LinkedListUtils.insertIntegers(50, 60, ll2);

        removeDuplicatesWithNoBuffer(ll2);

        System.out.println(ll2);

    }

    private static void removeDuplicatesWithBuffer(LinkedListNode<Integer> ll) {
        Set<Integer> hash = new HashSet<>();

        LinkedListNode<Integer> x = ll;
        LinkedListNode<Integer> prev = x;
        while(x != null) {
            //check if the hash contains current element, if it does not then add it to the hash table
            if (hash.contains(x.getValue())) {
                //now we found a duplicate, it cannot be the head so check prev and set its next to the
                // x.next so you skip current element
                prev.setNext(x.getNext());
            } else {
                hash.add(x.getValue());
                prev = x;
            }

            x = x.getNext();
        }
    }


    //EXTRA parse with no buffer
    // so this means we cannot use the hash table and the pointers, it makes the job a bit more difficult but not impossible
    private static void removeDuplicatesWithNoBuffer(LinkedListNode<Integer> ll) {
        LinkedListNode<Integer> x = ll;

        while(x != null) {
            LinkedListNode<Integer> r = x;
            while(r.getNext() != null) {
                if (r.getNext().getValue() == x.getValue()) {
                        r.setNext(r.getNext().getNext());
                } else
                    r = r.getNext();
            }

            x = x.getNext();
        }
    }

}
