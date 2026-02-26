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
		if (k == 1) return head;	
		ListNode curr = head;
		ListNode tail = head;
		ListNode dummyHead = new ListNode();
		dummyHead.next = head;
		ListNode prev = dummyHead;
		while (curr != null) {
			for (int i = 0; i < k; i++) {
				if (tail == null) return dummyHead.next;
				tail = tail.next;				
			}	
			prev.next = reverse(curr, tail);
			prev = curr;
			curr = curr.next;
		}
        return dummyHead.next;
	}
	
	private ListNode reverse(ListNode head, ListNode tail) {		
		ListNode curr = head;
		ListNode prev = null;

		while (curr != null && curr != tail) {	
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;			
		}
		head.next = tail;
		return prev;	
		
	}
}