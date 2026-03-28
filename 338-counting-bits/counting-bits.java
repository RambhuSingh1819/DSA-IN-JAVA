class Solution {
    public int[] countBits(int n) {

//ONE SOLUTION
        // int[] dp = new int[n + 1];
        
        // for (int i = 1; i <= n; i++) {
        //     dp[i] = dp[i >> 1] + (i & 1);
        // }
        
        // return dp;

        int[] list = new int[n+1];
        for(int i = 0; i <= n; i++){
            int num = i;
            int cnt = 0;
            while(num !=0){
                num = num & (num -1);
                cnt++;
            }
            list[i] = cnt;
        }
        return list;
    }
}