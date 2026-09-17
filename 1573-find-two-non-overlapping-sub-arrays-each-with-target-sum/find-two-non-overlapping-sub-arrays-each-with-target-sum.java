class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        if(n == 0) return 0;
        int[] temp = new int[n];
        int i = 0,sum = 0;
        int min = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++){
            sum += arr[j];
            // Shrink window from the left if sum exceeds target
            while (sum > target) {
                sum -= arr[i++];
            }
            // Valid subarray found in range [left, right]
            if(sum == target){
                int len = j-i+1;
                // Pair current subarray with the shortest non-overlapping subarray to its left
                if(i > 0 && temp[i-1] != Integer.MAX_VALUE){
                    ans = Math.min(ans, len + temp[i - 1]);
                }
                min = Math.min(min,len);
            }
            // Store the minimum subarray length found so far up to index 'right'
            temp[j] = min;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}