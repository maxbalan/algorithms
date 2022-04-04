package linkedlist.util;

/**
 * 30/10/18
 **/
public class LinkedListNode<P> {

    private P value;
    private LinkedListNode<P> next;

    public LinkedListNode(P value) {
        this.value = value;
    }

    public P getValue() {
        return this.value;
    }

    public void setValue(P value) {
        this.value = value;
    }

    public LinkedListNode<P> getNext() {
        return this.next;
    }

    public LinkedListNode setNext(LinkedListNode<P> next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedListNode<P> x = this;
        sb.append("[ ");

        while (x != null) {
            sb.append(x.value);
            x = x.next;

            if (x != null)
                sb.append(", ");
        }

        sb.append(" ]");

        return sb.toString();
    }

}
