package linkedlist.util;

/**
 * Date: 4/3/22
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode x = this;
        sb.append("[ ");

        while (x != null) {
            sb.append(x.val);
            x = x.next;

            if (x != null)
                sb.append(", ");
        }

        sb.append(" ]");

        return sb.toString();
    }
}
