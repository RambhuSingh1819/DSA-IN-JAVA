class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if( n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,nums,dp);
    }
    public int solve(int n, int[] nums, int[] dp){
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1) return dp[n];

        int left = solve(n-2,nums,dp) + nums[n];
        int right =  solve(n-1, nums,dp);

        return dp[n] = Math.max(left, right);
    }
}