class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            boolean des = false;
            int num = asteroids[i];
            while(!stk.isEmpty() && stk.peek() > 0 && num < 0){
                if(stk.peek() < Math.abs(num)) stk.pop();
                else if(stk.peek() == Math.abs(num)) {
                    stk.pop();
                    des = true;
                    break;
                }
                else{
                    des = true;
                    break;
                }
            }
            if(!des)
            stk.push(num);
        }
        int[] ans = new int[stk.size()];
       for(int i = ans.length-1; i >= 0; i--){
            ans[i] = stk.pop();
       }
       return ans;
    }
}