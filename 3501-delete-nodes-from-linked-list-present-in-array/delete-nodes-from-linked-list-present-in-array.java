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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int ele : nums){
            set.add(ele);
        }
        ListNode curr = new ListNode(0);
        curr.next = head;

        ListNode dummy = curr;

        while(dummy.next != null){
            if(set.contains(dummy.next.val)) dummy.next = dummy.next.next;
            else dummy = dummy.next;
        }
        return curr.next;
        
    }
}