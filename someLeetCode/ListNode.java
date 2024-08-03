package someLeetCode;

import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode temp = this;
        while (temp != null) {
            s.append(temp.val).append(" ");
            temp = temp.next;
            if (temp == this) break;
        }
        return s.toString();
    }
}


class run {
    public static void main(String[] args) {
        ListNode zeroth = new ListNode(9);
        ListNode first = new ListNode(9);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(9);
    }
}