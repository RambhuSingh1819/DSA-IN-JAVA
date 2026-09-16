class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        int c = n + k - 1;
        int r = 2 * k;
        return (int) combination(c, r);
    }

    public long combination(int n, int r) {
        if (r < 0 || r > n) return 0;
        r = Math.min(n - r, r);
        long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = (ans * (n - i + 1)) % MOD;  
            ans = (ans * modInverse(i)) % MOD;
        }
        return ans;
    }

    public long modInverse(long x) {
        return power(x, MOD - 2);
    }

    public long power(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}