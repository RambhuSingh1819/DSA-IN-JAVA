class Solution {
    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int subsequencePairCount(int[] nums) {
        int MOD = 1_000_000_007;
        int MAX_VAL = 200;
        long[][] dp = new long[MAX_VAL + 1][MAX_VAL + 1];
        
        dp[0][0] = 1;
        
        for (int x : nums) {
            long[][] nextDp = new long[MAX_VAL + 1][MAX_VAL + 1];
            
            for (int i = 0; i <= MAX_VAL; i++) {
                for (int j = 0; j <= MAX_VAL; j++) {
                    nextDp[i][j] = dp[i][j];
                }
            }
            
            for (int g1 = 0; g1 <= MAX_VAL; g1++) {
                for (int g2 = 0; g2 <= MAX_VAL; g2++) {
                    if (dp[g1][g2] > 0) {
                        long count = dp[g1][g2];
                        
                        int ng1 = gcd(g1, x);
                        nextDp[ng1][g2] = (nextDp[ng1][g2] + count) % MOD;
                        
                        int ng2 = gcd(g2, x);
                        nextDp[g1][ng2] = (nextDp[g1][ng2] + count) % MOD;
                    }
                }
            }
            
            dp = nextDp;
        }
        
        long ans = 0;
        for (int i = 1; i <= MAX_VAL; i++) {
            ans = (ans + dp[i][i]) % MOD;
        }
        
        return (int) ans;
    }
}