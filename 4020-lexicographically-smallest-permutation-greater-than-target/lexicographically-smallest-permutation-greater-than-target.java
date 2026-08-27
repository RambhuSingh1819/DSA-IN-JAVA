class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Find how many characters of target can be matched as a prefix
        int maxMatch = 0;
        int[] tempCount = count.clone();
        while (maxMatch < n) {
            char ch = target.charAt(maxMatch);
            if (tempCount[ch - 'a'] > 0) {
                tempCount[ch - 'a']--;
                maxMatch++;
            } else {
                break;
            }
        }

        // Try divergence points k from maxMatch down to 0
        for (int k = maxMatch; k >= 0; k--) {
            if (k < n) {
                char targetChar = target.charAt(k);
                int bestChar = -1;

                // Find the smallest character strictly greater than target[k]
                for (int c = targetChar - 'a' + 1; c < 26; c++) {
                    if (tempCount[c] > 0) {
                        bestChar = c;
                        break;
                    }
                }

                if (bestChar != -1) {
                    StringBuilder sb = new StringBuilder();
                    // 1. Matched prefix up to k - 1
                    sb.append(target, 0, k);
                    // 2. Diverging character at k
                    sb.append((char) ('a' + bestChar));
                    tempCount[bestChar]--;

                    // 3. Append all remaining characters in ascending order
                    for (int c = 0; c < 26; c++) {
                        while (tempCount[c] > 0) {
                            sb.append((char) ('a' + c));
                            tempCount[c]--;
                        }
                    }
                    return sb.toString();
                }
            }

            // Backtrack target[k - 1] to make it available for the next iteration
            if (k > 0) {
                tempCount[target.charAt(k - 1) - 'a']++;
            }
        }

        return "";
    }
}