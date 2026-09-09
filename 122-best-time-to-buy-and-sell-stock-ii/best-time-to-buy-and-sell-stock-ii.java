class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(0,1,n-1,prices,0,dp);
    }
    public int solve(int idx,int isBuy, int n, int[] prices,int profit,int[][]dp){

        if(idx == n){
            if(isBuy == 0) return prices[idx];
            else return 0;
        }
        if(dp[idx][isBuy] != -1) return dp[idx][isBuy];
        if(isBuy == 1){
            int Buy = (-prices[idx] + solve(idx+1,0,n,prices,profit,dp));
            int notBuy = solve(idx+1,1,n,prices,profit,dp);
            dp[idx][isBuy] =  Math.max(Buy,notBuy);
        }else{
            int Sell = (prices[idx]+solve(idx+1,1,n,prices,profit,dp));
            int notSell = solve(idx+1,0,n,prices,profit,dp);
            dp[idx][isBuy] = Math.max(Sell,notSell);
        }
        return dp[idx][isBuy];
    }
}