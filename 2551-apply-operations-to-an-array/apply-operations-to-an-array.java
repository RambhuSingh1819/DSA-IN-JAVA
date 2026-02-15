class Solution {
    public int[] applyOperations(int[] nums) {
        
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int j = 0;
        for(int ele = 0; ele < nums.length; ele++){
            if(nums[ele] != 0){
                int temp = nums[j];
                nums[j] = nums[ele];
                nums[ele] = temp;
                j++;
            }
        }
        return nums;
        
    }
}