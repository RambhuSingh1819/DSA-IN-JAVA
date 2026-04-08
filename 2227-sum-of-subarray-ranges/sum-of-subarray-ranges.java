import java.util.*;

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long maxSum = getMaxSum(nums);
        long minSum = getMinSum(nums);

        return maxSum - minSum;
    }
    private long getMaxSum(int[] nums) {
        int n = nums.length;
        int[] pge = new int[n]; 
        int[] nge = new int[n]; 

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                stk.pop();
            }
            pge[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }

        stk.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {
                stk.pop();
            }
            nge[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            sum += left * right * nums[i];
        }

        return sum;
    }
    private long getMinSum(int[] nums) {
        int n = nums.length;
        int[] pse = new int[n]; 
        int[] nse = new int[n]; 

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
                stk.pop();
            }
            pse[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }

        stk.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            nse[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sum += left * right * nums[i];
        }

        return sum;
    }
}