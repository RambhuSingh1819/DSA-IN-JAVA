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
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode right = head;
        int cnt = 1;

        while(right != null && cnt < k) {
            right = right.next;
            cnt++;
        }
        if(right == null) return head;

        ListNode next = right.next;
        right.next = null;

        ListNode tem1 = reverse(head);
        head.next = reverseKGroup(next,k);
        

        return tem1;
	}
    public ListNode reverse(ListNode root){
        ListNode prev = null;
        ListNode curr = root;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}