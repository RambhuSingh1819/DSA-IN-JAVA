class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(cnt == 0 && i == 0){
                majority = nums[i];
                cnt = 1;
            }
            else if(nums[i] == majority) cnt++;
            else cnt--;
            if(cnt == 0){
                majority = nums[i];
                cnt = 1;
            }
        }
        return majority;
        
    }
}