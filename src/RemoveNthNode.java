import java.util.List;

public class RemoveNthNode {
    public static void main (String args[]) {
        ListNode node = new ListNode(2);
        ListNode head = node;
        node.next = new ListNode(4);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(8);
        node.next.next.next.next = new ListNode(10);
        head = RemoveNthNodeSolution.removeNthFromEnd(head, 4);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
/*class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}*/
//To remove nth node from the end
class RemoveNthNodeSolution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode resHead = head;
        ListNode tmp2 = resHead;
        ListNode tmp3 = resHead;

        if (n==1) {
            if (resHead.next == null ) {
                return null;
            }
            while (tmp3.next != null){
                if (tmp3.next.next == null) {
                    tmp3.next = null;
                    break;
                }
                tmp3 = tmp3.next;
            }
            return resHead;
        } else {
            while (n > 1) {
                tmp3 = tmp3.next;
                n--;
            }
            if (resHead.next == tmp3 && tmp3.next == null) {
                return tmp3;
            } else {
                if (tmp3.next == null) {
                    resHead = resHead.next;
                    return resHead;
                }
                while (tmp3.next != null) {
                    if (tmp3.next.next == null) {
                        tmp2.next = tmp2.next.next;
                        break;
                    }
                    tmp2 = tmp2.next;
                    tmp3 = tmp3.next;
                }
            }
        }
        return resHead;
    }
}
