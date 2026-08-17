class Solution {
    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        int[] cumelativeSum = new int[n];
        cumelativeSum[0] = stoneValue[0];
        for(int i = 1; i < n; i++)  cumelativeSum[i] = cumelativeSum[i-1]+stoneValue[i];

        int[][] dp = new int[501][501];
        for(int[] row : dp) Arrays.fill(row,-1);

        return solve(0,n-1,cumelativeSum,dp);
        
    }
    public int solve(int left, int right,int[] cumSum,int[][] dp){
        if(left >= right) return 0;
        if(dp[left][right] != -1) return dp[left][right];
        int score = 0;
        for(int i = left; i < right; i++){
            int leftSum = cumSum[i] - (left-1 >= 0 ? cumSum[left-1] : 0);
            int rightSum = cumSum[right] - cumSum[i];
            if(leftSum < rightSum){
                score = Math.max(score,leftSum + solve(left,i,cumSum,dp));
            }else if(leftSum > rightSum){
                score = Math.max(score,rightSum + solve(i+1,right,cumSum,dp));
            }else{
                score = Math.max(score,Math.max(leftSum + solve(left,i,cumSum,dp),rightSum + solve(i+1,right,cumSum,dp))) ;
            }

        }
        return dp[left][right] = score;
    }
}