package linkedlist;

/**
 * 30/10/18
 *
 * Question:
 * Implement an algorithm to find the Kth to last element of a singly linked list
 *
 * k = 1 = last element
 * k = 2 = 1 to last element
 *
 *
 * Solution 1:
 * For this solution we gonna use a recursive call, so iterate through the list till we reach the last element and start
 * counting back until we hit the Kth element and print it.

 * Its a nice and simple solution though we don't have a way to return the Node back, unless we have a global variable to
 * assign it to.
 *
 * time: O(N) where N is the number of nodes in the list
 * space: O(N) where N is the number of nodes in the list
 *
 *
 * @author Maxim Balan
 **/
public class KthElementToLastV1 {

    public static void main(String[] args) {
        LinkedListNode<Integer> ll = LinkedListUtils.insertIntegers(1, 11);

        returnKthToLastNode(ll, 2);
        System.out.println(ll);
    }

    private static int returnKthToLastNode(LinkedListNode<Integer> ll, int k) {
//        if the next element is zero then it means we reached the tail of the list so we can start counting
        if (ll == null) return 0;

        int index = returnKthToLastNode(ll.getNext(), k) + 1;

        if (index == k)
            System.out.println(String.format("%dth element to last is [ %d ]", k, ll.getValue()));

        return index;
    }

}
