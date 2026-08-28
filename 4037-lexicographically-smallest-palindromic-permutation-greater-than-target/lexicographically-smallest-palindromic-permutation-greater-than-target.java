class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // 1. Verify if s can form a palindrome and determine the fixed half-character pool
        int oddCount = 0;
        String midChar = "";
        int[] halfCount = new int[26];

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = String.valueOf((char) ('a' + i));
            }
            halfCount[i] = count[i] / 2;
        }

        // A valid palindrome requires at most one odd-frequency character
        if (oddCount > 1 || (n % 2 == 0 && oddCount != 0)) {
            return "";
        }

        int m = n / 2;
        String targetHalf = target.substring(0, m);

        // 2. Case A: Check if the exact target prefix can form a palindrome strictly > target
        if (canFormExactPrefix(targetHalf, halfCount)) {
            String candidate = targetHalf + midChar + new StringBuilder(targetHalf).reverse().toString();
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        // 3. Case B: Find the lexicographically smallest first-half H strictly > targetHalf
        int maxMatch = 0;
        int[] tempCount = halfCount.clone();
        while (maxMatch < m) {
            char ch = targetHalf.charAt(maxMatch);
            if (tempCount[ch - 'a'] > 0) {
                tempCount[ch - 'a']--;
                maxMatch++;
            } else {
                break;
            }
        }

        for (int k = maxMatch; k >= 0; k--) {
            if (k < m) {
                char targetChar = targetHalf.charAt(k);
                int bestChar = -1;

                // Pick the smallest available character strictly greater than targetHalf[k]
                for (int c = targetChar - 'a' + 1; c < 26; c++) {
                    if (tempCount[c] > 0) {
                        bestChar = c;
                        break;
                    }
                }

                if (bestChar != -1) {
                    StringBuilder half = new StringBuilder();
                    half.append(targetHalf, 0, k);
                    half.append((char) ('a' + bestChar));
                    tempCount[bestChar]--;

                    // Fill the remainder of the first half in ascending order
                    for (int c = 0; c < 26; c++) {
                        while (tempCount[c] > 0) {
                            half.append((char) ('a' + c));
                            tempCount[c]--;
                        }
                    }

                    String firstHalf = half.toString();
                    return firstHalf + midChar + new StringBuilder(firstHalf).reverse().toString();
                }
            }

            // Backtrack targetHalf[k - 1] into available pool for next iteration
            if (k > 0) {
                tempCount[targetHalf.charAt(k - 1) - 'a']++;
            }
        }

        return "";
    }

    private boolean canFormExactPrefix(String prefix, int[] halfCount) {
        int[] req = new int[26];
        for (char ch : prefix.toCharArray()) {
            req[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (req[i] != halfCount[i]) return false;
        }
        return true;
    }
}