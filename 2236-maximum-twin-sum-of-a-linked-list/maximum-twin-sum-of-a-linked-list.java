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
    public int pairSum(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode last = reverse(slow);
        ListNode temp = head;
        int ans = 0;
        while(temp != null && last != null){
            int num = temp.val+last.val;
            ans = Math.max(ans,num);
            temp = temp.next;
            last = last.next;
        }
        return ans;
        
    }
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}