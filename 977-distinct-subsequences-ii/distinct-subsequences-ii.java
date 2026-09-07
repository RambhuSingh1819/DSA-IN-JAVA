class Solution {
    public int distinctSubseqII(String s) {
        int MOD = (int)1e9+7;
        int[] existCnt = new int[26];
        int ans = 0;
        for(char it : s.toCharArray()){
            int ch = it-'a';
            int newCntSub = (ans+1)%MOD;
            int diff = (newCntSub - existCnt[ch] + MOD)% MOD;
            ans = (ans + diff) % MOD;
            existCnt[ch] = newCntSub; 
        }
        return ans;
    }
}