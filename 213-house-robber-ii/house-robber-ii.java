class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int a = nums[0];
        int b = Math.max(nums[0],nums[1]);
        int c = 0;
        int num1 = -1;
        for(int i = 2; i < n-1; i++){
            c = Math.max(nums[i]+a,b);
            a = b;
            b = c;
        }
        int r1 = b;


        a = nums[1];
        b = Math.max(nums[1],nums[2]);
        c = 0;
        for(int i = 3; i < n; i++){
            c = Math.max(nums[i]+a,b);
            a = b;
            b = c;
           
        }
        r1 = Math.max(r1,b);
        return r1;
        
    }
}