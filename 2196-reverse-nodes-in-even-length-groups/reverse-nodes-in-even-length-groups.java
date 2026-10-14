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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head == null || head.next == null) return head;        
        int group = 1;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null && curr.next != null){
            int gp = group;
            int len = 1;
            if(group == 1) {prev = curr; group++; curr = curr.next ; continue;}
            while(curr.next != null && gp > 1){
                curr = curr.next;
                gp--;
                len++;
            }
            if(len%2 == 0){
                ListNode nxt = null;
                if(curr.next != null){ nxt = curr.next;curr.next = null;}
                
                ListNode rev = reverse(prev.next);
                prev.next = rev;
                while(rev.next != null){
                    rev = rev.next;
                }
                rev.next = nxt;
                prev = rev;
            }else{
                prev = curr;
            }
            group++;
            
            curr = prev.next;
        }
        return head;
    }
    public ListNode reverse(ListNode node){
        if(node == null) return null;
        ListNode prev = null;
        ListNode curr = node;
        while(curr!= null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    } 
}