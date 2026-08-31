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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null) return new int[]{-1,-1};
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode nextNode = curr.next;
        while(nextNode != null){
            if(curr.val < prev.val && curr.val < nextNode.val){
                list.add(idx);
            }
            else if(curr.val > prev.val && curr.val > nextNode.val){
                list.add(idx);  
            }
            idx++;
            prev = curr;
            curr = nextNode;
            nextNode = nextNode.next;
        }
        if (list.size() < 2) {
            return new int[]{-1, -1};
        }
        int minVal = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            minVal = Math.min(minVal,list.get(i)-list.get(i-1));
        }
        int maxVal = list.get(list.size()-1)-list.get(0);
        return new int[]{minVal, maxVal};
        
    }
}