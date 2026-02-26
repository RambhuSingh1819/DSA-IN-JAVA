/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;
        ListNode temp = head;
        ListNode tem = head;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }
        if(k % len == 0) return head;
        k = k % len;
        tail.next = head;
        int n = (len-k);
        while(n != 1){
            temp = temp.next;
            n--;
        }
            head=temp.next ;
            temp.next = null;
        return head;
    }
}
