class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for(int i = 1; i < n; i++){
            pre[i] = pre[i-1]*nums[i-1];
        }
        int pro = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            pre[i] = pro * pre[i];
            pro = pro * nums[i];
        }
        return pre;
    }
}