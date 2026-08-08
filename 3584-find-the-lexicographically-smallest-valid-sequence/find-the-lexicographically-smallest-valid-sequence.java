class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] rightMatch = new int[m];
        int j = n - 1;
        
        for (int i = m - 1; i >= 0; i--) {
            while (j >= 0 && word1.charAt(j) != word2.charAt(i)) {
                j--;
            }
            if (j >= 0) {
                rightMatch[i] = j;
                j--;
            } else {
                rightMatch[i] = -1; 
            }
        }
        
        int[] ans = new int[m];
        boolean changed = false;
        j = 0;
        
        for (int i = 0; i < m; i++) {
            boolean matched = false;
            
            while (j < n) {
                if (word1.charAt(j) == word2.charAt(i)) {
                    ans[i] = j;
                    j++;
                    matched = true;
                    break;
                } else if (!changed && (i == m - 1 || (rightMatch[i + 1] != -1 && rightMatch[i + 1] > j))) {
                    
                    ans[i] = j;
                    changed = true;
                    j++;
                    matched = true;
                    break;
                }
                j++;
            }
            
            if (!matched) {
                return new int[0];
            }
        }
        
        return ans;
    }
}