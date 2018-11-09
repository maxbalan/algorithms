package linkedlist;

import linkedlist.util.LinkedListNode;
import linkedlist.util.LinkedListUtils;

import java.util.Stack;

/**
 * 02/11/18
 *
 * Question:
 * Implement an algorithm that will check if a list is a palindrome
 *
 * NOTE: as there is no mentioning of type and permutation, I will assume the type is Integer and the list needs to be a
 * palindrome and not a permutation of it
 *
 * Example:
 * 1 -> 2 -> 1 - is a palindrome
 * 1 -> 1 -> 2 - is not a palindrome
 *
 * Solution 1:
 * so as we mentioned above we set some boundaries for this problem and can attend to solve it, as we said that it has to
 * be a palindrome and not a permutation of the nodes has to be a palindrome we can iterate through the list and create
 * an inverse version of it while doing so we also create a counter too. The counter is useful as for the next step we
 * have to compare the inverse List and the original one and they have to be the same but we don't have to iterate through
 * all nodes we need only half of them as we are going to compare first half with second one.
 *
 * A small note is when we divide the counter we have to make sure it is even as for the case it is odd, subtracting one
 * will make it even and after dividing it we add 1 just so we compare the mid point too
 *
 *
 * Solution 2:
 * this solution is very similar to first one, but instead of inverting the list we use a slow-fast pointer technique,
 * so the slow pointer will push the value of the nodes into a Stack and when the fast pointer reached the end, this means
 * we actually reached the middle of the list. Now when popping elements out of the Stack we have them in the inverse order
 * all that remains is to compare them to the rest of the slow pointer list
 *
 * @author Maxim Balan
 **/
public class ListPalindromeV2 {
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
        LinkedListNode<Integer> fast = ll;
        LinkedListNode<Integer> slow = ll;
        Stack<Integer> stack = new Stack<>();

        while(fast != null) {
            stack.push(slow.getValue());

            if (fast.getNext() == null) {
                break;
            }

            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        boolean isPalindrome = true;
        while(slow != null) {
            if (slow.getValue() != stack.pop()) {
                isPalindrome = false;
                break;
            }

            slow = slow.getNext();
        }

        return isPalindrome;
    }

}
