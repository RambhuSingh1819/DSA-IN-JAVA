class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n == 0) return m;
        if(m == 0) return n;
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(n-1,m-1,word1,word2,dp);
    }
    public int solve(int i, int j , String s , String t,int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return solve(i-1,j-1,s,t,dp);
        }else{
            //INSERT
            int insert = 1 + solve(i,j-1,s,t,dp);
            //delete
            int del = 1 + solve(i-1,j,s,t,dp);
            //REPLACE
            int replace = 1 + solve(i-1,j-1,s,t,dp);
            return dp[i][j] = Math.min(insert,Math.min(del,replace));
        }
    }
}