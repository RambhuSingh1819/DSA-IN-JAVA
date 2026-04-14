import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        
        int[] chr = new int[256];
        Arrays.fill(chr, -1);
        int left = 0, maxLen = 0;
        
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            
            if(chr[c] != -1 && chr[c] >= left){
                left = chr[c] + 1;
            }
            chr[c] = right;
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
        }  
        return maxLen;
    }
}