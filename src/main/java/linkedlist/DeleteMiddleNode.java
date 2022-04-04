package linkedlist;

import linkedlist.util.LinkedListNode;
import linkedlist.util.LinkedListUtils;

/**
 * 31/10/18
 * <p>
 * Question:
 * Implement an algorithm to delete a node in the middle (any node but the first and last node, not necessarily the exact
 * middle) of a singly linked list, given only access to that node
 * <p>
 * Example:
 * Input: the node c from the linked list a -> b -> c -> d -> e -> f
 * Result: nothing is returned, but the new linked list looks like a -> b -> d -> e -> f
 * <p>
 * Solution:
 * As this is a singly linked list we have no way of knowing if this is the first node or not, unless the size of the
 * list is also given, but we can understand if this is the last node by checking that the next link is empty, so the
 * problem itself is fairly easy as we only replace the link to to skip the node we were given
 **/
public class DeleteMiddleNode {

    public static void main(String[] args) {
        LinkedListNode<Integer> ll = LinkedListUtils.generateIntegerLinkedList(1, 11);
        LinkedListNode<Integer> remove = ll.getNext().getNext().getNext();

        System.out.println("Remove: " + remove.getValue());

        removeNode(remove);
        System.out.println(ll);
    }

    private static void removeNode(LinkedListNode<Integer> node) {
        //check if this is the last node then leave the list as it is or its an invalid node
        if (node == null || node.getNext() == null) return;

        node.setValue(node.getNext().getValue());
        node.setNext(node.getNext().getNext());
    }

}
