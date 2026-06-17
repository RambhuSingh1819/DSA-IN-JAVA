class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        boolean b = true;
        while(n > 1){
            for(int i = 0; i < n-1; i+=2){
                if(b){
                    nums[i/2] = Math.min(nums[i],nums[i+1]);
                    b = false;
                }
                else if(!b){
                    nums[i/2] = Math.max(nums[i],nums[i+1]);
                    b = true;
                }
                
            }
                n /=2;
        }
        return nums[0];
    }
}