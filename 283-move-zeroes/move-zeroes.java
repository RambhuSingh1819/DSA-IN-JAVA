import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroPosition = 0;
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != 0){
                int temp = nums[index];
                nums[index] = nums[nonZeroPosition];
                nums[nonZeroPosition] = temp;
                nonZeroPosition++;
            }
        }
    }
}
