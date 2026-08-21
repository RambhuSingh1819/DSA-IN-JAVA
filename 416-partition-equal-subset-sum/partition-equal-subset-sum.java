class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum % 2 != 0) return false;
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(n-1,nums,target,dp);
    }
    public boolean solve(int idx, int[] nums, int k, int[][] dp){
        if(k == 0) return true;
        if(idx == 0) return nums[0] == k;
        if(dp[idx][k] != -1) return dp[idx][k] == 1;
        boolean notTake = solve(idx-1,nums,k,dp);
        boolean take = false;
        if(nums[idx] <= k){
            take = solve(idx-1,nums,k-nums[idx],dp);
        }
        boolean res = take || notTake;
        dp[idx][k] = res ? 1 : 0;
        return res;
    }
}