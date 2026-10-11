class Solution {
    public int maxWidthRamp(int[] nums) {

        Stack<Integer> stk = new Stack<>();

        // Store indices with strictly decreasing values
        for (int i = 0; i < nums.length; i++) {
            if (stk.isEmpty() || nums[stk.peek()] > nums[i]) {
                stk.push(i);
            }
        }

        int ans = 0;

        // Traverse from right to left
        for (int j = nums.length - 1; j >= 0; j--) {

            while (!stk.isEmpty() && nums[stk.peek()] <= nums[j]) {
                int i = stk.pop();
                ans = Math.max(ans, j - i);
            }
        }

        return ans;
    }
}