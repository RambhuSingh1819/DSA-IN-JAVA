class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int sFinalLength = 0;
        for(int cnt : freq){
            if(cnt == 0) continue;
            if(cnt % 2 == 0) sFinalLength+=2;
            else{
                sFinalLength++;
            }

        }
        return sFinalLength;
    }
}