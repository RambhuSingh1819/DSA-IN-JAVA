class Solution {
    public int majorityElement(int[] nums) {
     if(nums.length < 2) return nums[0];
     int cnt = 1;
     int el = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            if(nums[i] == el) cnt++;
            else cnt--;
            if(cnt == 0) {
                el = nums[i];
                cnt = 1;
            }
        }
        return el;
    }
}