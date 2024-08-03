package someLeetCode;

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {

        ListNode cur = head;

        int len = 0;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        len++;

        cur.next = head;
        k = k % len;
        cur = head;

        while (len - k - 1 != 0) {
            cur = cur.next;
            k++;
        }

        ListNode ans = cur.next;

        cur.next = null;

        return ans;
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;


        System.out.println(rotateRight(one, 4));

    }
}
