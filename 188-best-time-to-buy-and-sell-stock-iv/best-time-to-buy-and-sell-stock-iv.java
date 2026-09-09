class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }
        int[][][] dp = new int[n+1][2][k+1];
        for(int i = n-1; i >= 0; i--){
            for(int b = 0; b <= 1; b++){
                for(int j = 1; j <= k; j++){

                    if(b == 1){
                        int buy = -prices[i]+dp[i+1][0][j];
                        int notBuy = dp[i+1][1][j];
                        dp[i][b][j] = Math.max(buy,notBuy);
                    }else{
                        int sell = prices[i]+dp[i+1][1][j-1];
                        int notSell = dp[i+1][0][j];
                        dp[i][b][j] = Math.max(sell,notSell);
                    }

                }
            }
        }
        return dp[0][1][k];
        
    }
}