class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int i = 0,ans = 0;
        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            freq[ch-'a']++;
            while(freq[ch-'a'] > 2){
                freq[s.charAt(i) -'a']--;
                i++;
            }
            ans = Math.max(ans,j - i + 1);
        }
        return ans;
    }
}