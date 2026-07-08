class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n  = cost.length;
        int a = cost[0];
        int b = cost[1];

        for(int i = 2; i < n; i++){
            int curr = cost[i] + Math.min(a,b);
            a = b;
            b = curr;
        }
        return Math.min(a,b);
        
    }
}