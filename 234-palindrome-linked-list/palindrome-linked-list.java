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
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        temp = null;
        ListNode curr = head;
        for(int i = 0; i < len/2; i++){
            ListNode next = curr.next;
            curr.next = temp;
            temp = curr;
            curr = next;
        }
        if(len % 2 == 1) curr= curr.next;
        while(temp != null){
            if(curr.val != temp.val) return false;
            curr = curr.next;
            temp = temp.next;
        }
        return true;
    }
}