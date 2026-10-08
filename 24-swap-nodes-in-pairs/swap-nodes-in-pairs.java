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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode curr = temp;
        while(curr.next != null && curr.next.next != null){
            ListNode first = curr.next;
            ListNode sec = curr.next.next;

            first.next = sec.next;
            sec.next = first;
            curr.next = sec;

            curr = first;

        }
        return temp.next;
    }
}