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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int partSize = len / k;
        int extra = len % k;

        ListNode[] ans = new ListNode[k];
        curr = head;

        for (int i = 0; i < k; i++) {
            if (curr == null) {
                ans[i] = null;
                continue;
            }

            ans[i] = curr;

            int currentPartSize = partSize;

            if (extra > 0) {
                currentPartSize++;
                extra--;
            }
            for (int j = 1; j < currentPartSize; j++) {
                curr = curr.next;
            }
            ListNode nextPart = curr.next;
            curr.next = null;
            curr = nextPart;
        }

        return ans;
    }
}