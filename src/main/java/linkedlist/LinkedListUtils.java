package linkedlist;

/**
 * 30/10/18
 *
 * @author Maxim Balan
 **/
public class LinkedListUtils {

    public static LinkedListNode<Integer> insertIntegers(int from, int upTo) {
        LinkedListNode<Integer> fakeHead = new LinkedListNode<>(0);
        LinkedListNode<Integer> x = fakeHead;

        for (int i = from; i < upTo; i++) {
            x.setNext(new LinkedListNode<>(i));
            x = x.getNext();
        }

        return fakeHead.getNext();
    }

    public static void insertIntegers(int from, int upTo, LinkedListNode<Integer> ll) {
        LinkedListNode<Integer> x = ll;

        while(x.getNext() != null) {
            x = x.getNext();
        }

        for (int i = from; i < upTo; i++) {
            x.setNext(new LinkedListNode<>(i));
            x = x.getNext();
        }
    }

}
