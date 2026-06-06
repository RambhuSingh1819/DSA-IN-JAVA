class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] temp = new int[nums.length];
        int sum = 0;
        for(int i = 1; i < nums.length; i++){
            temp[i] = sum += nums[i-1];
        }
        sum = 0;
        for(int i = nums.length-2; i >= 0; i--){
            sum += nums[i+1];
            temp[i] -= sum;
        }
        for (int i = 0; i < nums.length; i++) {
            temp[i] = Math.abs(temp[i]);
        }
        return temp;
    }
}