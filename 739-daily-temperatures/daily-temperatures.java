class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int[] stk = new int[n];
        int top = -1;
        for(int i = n-1; i >= 0; i--){
            while(top != -1 && temperatures[stk[top]] <= temperatures[i]){
                top--;
            }
            res[i] = (top == -1) ? 0 : stk[top]-i;
            stk[++top] = i;
        }
        return res;
        
    }
}