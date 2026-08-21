class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int maxMask = 1 << n; // Total subsets = 2^n
        
        // Precompute LCMs and Signs for all subsets
        long[] lcms = new long[maxMask];
        int[] signs = new int[maxMask];
        
        lcms[0] = 1;
        for (int i = 1; i < maxMask; i++) {
            // Find the lowest set bit to quickly build on previous LCMs
            int lowestBit = Integer.numberOfTrailingZeros(i);
            int prevMask = i ^ (1 << lowestBit);
            
            lcms[i] = lcm(lcms[prevMask], coins[lowestBit]);
            // If subset size is odd, sign is +1. If even, sign is -1.
            signs[i] = (Integer.bitCount(i) % 2 == 1) ? 1 : -1;
        }
        
        // Binary Search bounds
        long low = 1;
        long minCoin = coins[0];
        for (int coin : coins) minCoin = Math.min(minCoin, coin);
        long high = minCoin * k; // The theoretical maximum possible answer
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = 0;
            
            // Apply Inclusion-Exclusion principle for 'mid'
            for (int i = 1; i < maxMask; i++) {
                count += signs[i] * (mid / lcms[i]);
            }
            
            // If count is >= k, this 'mid' could be the answer, but try going smaller
            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; // 'mid' is too small, increase the search space
            }
        }
        
        return ans;
    }
    
    // Helper to calculate Greatest Common Divisor
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    // Helper to calculate Least Common Multiple
    private long lcm(long a, long b) {
        // Safe from overflow here because max LCM for integers <= 25 is ~2.6e10 (fits in long)
        return a * (b / gcd(a, b)); 
    }
}