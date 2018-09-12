package easy.reverseLinkedList;

import java.util.List;

/**
 * Created by hejiajun
 * On 2018/9/12
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * a. 1 -> 2 -> 3
 * b. 1 -> null ; 2 -> 3
 * c. 2 -> 1 -> null ; 3
 * d. 3 -> 2 -> 1 -> null;
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        ListNode result = new Solution().reverse(l1);
        System.out.println(result);
    }

    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (null == head || null == head.next) {
            return head;
        }

        ListNode temp = null;
        ListNode prev = null;

        while (null != head) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

}
