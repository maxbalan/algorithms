package linkedlist.util;

import java.util.Random;

/**
 * 30/10/18
 *
 * @author Maxim Balan
 **/
public class LinkedListUtils {

    public static LinkedListNode<Integer> generateIntegerLinkedList(int from, int upTo) {
        LinkedListNode<Integer> fakeHead = new LinkedListNode<>(0);
        LinkedListNode<Integer> x = fakeHead;

        for (int i = from; i < upTo; i++) {
            x.setNext(new LinkedListNode<>(i));
            x = x.getNext();
        }

        return fakeHead.getNext();
    }

    public static void insertInteger(int from, int upTo, LinkedListNode<Integer> ll) {
        LinkedListNode<Integer> x = ll;

        while(x.getNext() != null) {
            x = x.getNext();
        }

        for (int i = from; i < upTo; i++) {
            x.setNext(new LinkedListNode<>(i));
            x = x.getNext();
        }
    }

    public static  LinkedListNode<Integer> generateRandomIntegerLinkedList(int min, int max, int size) {
        Random random = new Random();

        LinkedListNode<Integer> fakeHead = new LinkedListNode<>(0);
        LinkedListNode<Integer> x = fakeHead;

        for (int i = 0; i < size; i++) {
            int a = random.nextInt(max - min +1) + min;
            x.setNext(new LinkedListNode<>(a));
            x = x.getNext();
        }

        return fakeHead.getNext();
    }

}
