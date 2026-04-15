class Solution {
    public int numberOfSubstrings(String s) {
        int[] ans = new int[]{-1,-1,-1};
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            ans[ch-'a'] = i;
            if(ans[0] != -1 && ans[1] != -1 && ans[2] != -1){
                 cnt = cnt + (1+Math.min(ans[0],Math.min(ans[1],ans[2])));
            }
        }
        return cnt;
    }
}