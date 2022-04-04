package linkedlist;

import linkedlist.util.LinkedListNode;
import linkedlist.util.LinkedListUtils;

/**
 * 02/11/18
 * <p>
 * Question:
 * Implement an algorithm that will check if a list is a palindrome
 * <p>
 * NOTE: as there is no mentioning of type and permutation, I will assume the type is Integer and the list needs to be a
 * palindrome and not a permutation of it
 * <p>
 * Example:
 * 1 -> 2 -> 1 - is a palindrome
 * 1 -> 1 -> 2 - is not a palindrome
 * <p>
 * Solution 1:
 * so as we mentioned above we set some boundaries for this problem and can attend to solve it, as we said that it has to
 * be a palindrome and not a permutation of the nodes has to be a palindrome we can iterate through the list and create
 * an inverse version of it while doing so we also create a counter too. The counter is useful as for the next step we
 * have to compare the inverse List and the original one and they have to be the same but we don't have to iterate through
 * all nodes we need only half of them as we are going to compare first half with second one.
 * <p>
 * A small note is when we divide the counter we have to make sure it is even as for the case it is odd, subtracting one
 * will make it even and after dividing it we add 1 just so we compare the mid point too
 *
 * @author Maxim Balan
 **/
public class ListPalindromeV1 {
    public static void main(String[] args) {
//        odd node count palindrome
        LinkedListNode<Integer> ll = LinkedListUtils.generateIntegerLinkedList(1, 5);
        LinkedListUtils.insertIntegerReverse(0, 3, ll);

        System.out.println("List: " + ll + " is palindrome: " + isPalindrome(ll));

//        even node count palindrome
        ll = LinkedListUtils.generateIntegerLinkedList(1, 5);
        LinkedListUtils.insertIntegerReverse(0, 4, ll);
        System.out.println("List: " + ll + " is palindrome: " + isPalindrome(ll));

//        not a palindrome
        ll = LinkedListUtils.generateIntegerLinkedList(1, 5);
        LinkedListUtils.insertIntegerReverse(0, 2, ll);
        System.out.println("List: " + ll + " is palindrome: " + isPalindrome(ll));

    }

    private static boolean isPalindrome(LinkedListNode<Integer> ll) {
        LinkedListNode<Integer> f = ll;
        LinkedListNode<Integer> x = ll;
        LinkedListNode<Integer> b = new LinkedListNode<>(0);

        //create an inverted list and count the nodes
        int count = 0;
        while (x != null) {
            count++;
            b = new LinkedListNode<>(x.getValue()).setNext(b);
            x = x.getNext();
        }

        if (count == 1) return true; //its a list of 1 node
        else if (count == 0) return false; // a null list was provided

        //we need to parse only half the list in order to understand if its a palindrome
        if (count % 2 == 0)
            count = (count / 2);
        else
            count = ((count - 1) / 2) + 1;

        boolean isPalindrome = false;
        for (int i = 0; i < count; i++) {
            if (f.getValue() == b.getValue()) isPalindrome = true;
            else {
                isPalindrome = false;
                break;
            }

            f = f.getNext();
            b = b.getNext();
        }

        return isPalindrome;
    }

}
