class Solution {
    public int[] transformArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return new int[]{};
        int i = 0, j =0;
        while(j < n){
            if(nums[j] % 2 == 0){
                nums[j] = 0;
                swap(nums,i,j);
                i++;
                j++;
            }else {
                nums[j] = 1;
                j++;
            }
        }  
        return nums;
    }
    public void swap(int[] nums, int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}