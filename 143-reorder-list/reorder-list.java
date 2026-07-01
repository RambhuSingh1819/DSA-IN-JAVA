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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null; 

        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode first = head;
        ListNode sec = prev;

        while(sec != null){
            ListNode temp1 = first.next;
            ListNode temp2 = sec.next;
            first.next = sec;
            sec.next = temp1;

            first = temp1;
            sec = temp2;
        }
    }
}