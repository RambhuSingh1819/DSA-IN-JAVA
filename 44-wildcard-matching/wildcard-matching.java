/*class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return solve(n,m,s,p,dp);
    }
    public boolean solve(int i, int j, String s, String p,Boolean[][]dp){
        if(i == 0 && j == 0) return true;
        if(j == 0 && i >= 0) return false;
        if(i == 0 && j >= 0){
            for(int k = 1; k <= j; k++){
                if(p.charAt(k-1) != '*') return false;
            }
            return true;
        }
        if (dp[i][j] != null) return dp[i][j];
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) =='?'){
            return dp[i][j] = solve(i-1,j-1,s,p,dp);
        }
        if(p.charAt(j-1) == '*'){
            return dp[i][j] = solve(i-1,j,s,p,dp) || solve(i,j-1,s,p,dp);
        }
        return dp[i][j] = false;
    }
}*/
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (sc == pc || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}