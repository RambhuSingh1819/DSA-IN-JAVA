class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stk = new Stack<>(); 
        for(int i = 0 ; i < 2*n ; i++){
            int ans = nums[i%n];
            while(!stk.isEmpty() && nums[stk.peek()] < ans){
                res[stk.pop()] = ans;
            }
            if(i < n) stk.push(i);
        }
        return res;  
    }
}