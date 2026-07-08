class Solution {
    static final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Precompute powers of 10 modulo 10^9 + 7
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix arrays (1-indexed to easily handle L=0 boundaries)
        int[] cnt = new int[n + 1];
        long[] sum = new long[n + 1];
        long[] val = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                // Zeroes don't change the concatenated number or sum
                cnt[i + 1] = cnt[i];
                sum[i + 1] = sum[i];
                val[i + 1] = val[i];
            } else {
                int digit = c - '0';
                cnt[i + 1] = cnt[i] + 1;
                sum[i + 1] = sum[i] + digit;
                // Shift previous value left by 1 base-10 spot and add the new digit
                val[i + 1] = (val[i] * 10 + digit) % MOD;
            }
        }

        int[] ans = new int[queries.length];
        
        // Process each query in O(1) time
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            // 1. Calculate the number of non-zero digits in the range [l, r]
            int k = cnt[r + 1] - cnt[l];
            
            // 2. Calculate the sum of those digits
            long currentSum = sum[r + 1] - sum[l];
            
            // 3. Extract the concatenated integer X using modular arithmetic
            long x = (val[r + 1] - (val[l] * pow10[k]) % MOD) % MOD;
            
            // Handle negative results from modulo subtraction
            if (x < 0) {
                x += MOD; 
            }

            // 4. Calculate the final answer for this query
            ans[i] = (int) ((x * (currentSum % MOD)) % MOD);
        }

        return ans;
    }
}