class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        int count=0;
        while(j < n){
            count += nums[j];
            while(count >= target){
                int len = j - i + 1;
                count -= nums[i];
                ans = Math.min(len,ans);
                i++;
            }
            j++;
        }

        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}