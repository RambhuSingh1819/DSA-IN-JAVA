class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        int[] h = new int[26];
        int midChar = -1;
        int n = 0;
        
        // Find the middle character (if odd length) and populate the half-counts
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                midChar = i;
            }
            h[i] = count[i] / 2;
            n += h[i];
        }
        
        // If there are fewer than k permutations available overall, return empty string
        long totalWays = getWays(h);
        if (k > totalWays) {
            return "";
        }
        
        StringBuilder leftHalf = new StringBuilder(n);
        
        // Build the left half character by character
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 26; c++) {
                if (h[c] > 0) {
                    h[c]--; // Provisionally place the character
                    long w = getWays(h);
                    
                    if (k <= w) {
                        // The k-th permutation falls within this branch
                        leftHalf.append((char) (c + 'a'));
                        break; 
                    } else {
                        // The k-th permutation is further down, skip these 'w' permutations
                        k -= (int) w;
                        h[c]++; // Backtrack and try the next character
                    }
                }
            }
        }
        
        // Assemble the final palindrome
        StringBuilder ans = new StringBuilder(leftHalf.toString());
        if (midChar != -1) {
            ans.append((char) (midChar + 'a'));
        }
        ans.append(leftHalf.reverse());
        
        return ans.toString();
    }
    
    /**
     * Calculates the number of unique permutations possible with the given character counts.
     * Capped safely at 1,000,001 to prevent long overflows since Max(k) is 10^6.
     */
    private long getWays(int[] h) {
        long w = 1;
        int n = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= h[i]; j++) {
                n++;
                w = w * n / j;
                // Early exit optimized threshold (w acts monotonically increasing in this loop structure)
                if (w > 1_000_000) {
                    return 1_000_001;
                }
            }
        }
        return w;
    }
}