/*
//USING DP 
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0,1,prices,2,0,dp);
        
    }
    public int solve(int idx, int buy, int[] prices,int cap,int ans,int[][][] dp){
        if(cap == 0 || idx == prices.length) return 0;
        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
        if(buy == 1){
            int Buy = (-prices[idx]+solve(idx+1,0,prices,cap,ans,dp));
            int notBuy = solve(idx+1,1,prices,cap,ans,dp);
            ans = Math.max(Buy,notBuy);
            dp[idx][buy][cap] = ans;
        }else{
            int Sell = prices[idx] + solve(idx+1, 1,prices,cap-1,ans,dp);
            int notSell = solve(idx+1,0,prices,cap,ans,dp);
            ans = Math.max(Sell,notSell);
            dp[idx][buy][cap] = ans;
        }
        return dp[idx][buy][cap];
    }
}
*/
class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for(int ele : prices){
            buy1 = Math.max(-ele , buy1);
            sell1 = Math.max(sell1,ele + buy1);
            buy2 = Math.max(sell1-ele,buy2);
            sell2 = Math.max(sell2,ele+buy2);
        }
        return sell2;
    }
}