class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Dummy node handles the edge case where left == 1 cleanly
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // 1. Move `prev` to the node *right before* the `left` position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // 2. `curr` is the first node of the sublist to be reversed
        ListNode curr = prev.next;
        ListNode subListHead = curr; // This will become the tail after reversal

        // 3. Reverse the sublist from `left` to `right`
        ListNode prevNode = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode nextTemp = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextTemp;
        }

        // 4. Reconnect the reversed sublist back to the main list
        prev.next = prevNode;       // Connect the node before `left` to the new head of sublist
        subListHead.next = curr;    // Connect the old sublist head to the remaining list (`right.next`)

        return dummy.next;
    }
}