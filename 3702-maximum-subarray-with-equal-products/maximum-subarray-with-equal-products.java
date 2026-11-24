class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        // Every subarray of length 2 is guaranteed to be valid: a * b == lcm(a, b) * gcd(a, b)
        int maxLen = Math.min(n, 2);
        
        // Precomputed prime factor bitmasks for numbers 1 to 10 (primes: 2, 3, 5, 7)
        // 1 -> 0000 (0), 2 -> 0001 (1), 3 -> 0010 (2), 4 -> 0001 (1), 5 -> 0100 (4)
        // 6 -> 0011 (3), 7 -> 1000 (8), 8 -> 0001 (1), 9 -> 0010 (2), 10 -> 0101 (5)
        int[] primeMask = {0, 0, 1, 2, 1, 4, 3, 8, 1, 2, 5};
        
        int windowMask = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            int currMask = primeMask[nums[right]];
            
            // Shrink window until no prime factors overlap with nums[right]
            while ((windowMask & currMask) != 0) {
                windowMask ^= primeMask[nums[left]];
                left++;
            }
            
            windowMask |= currMask;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}