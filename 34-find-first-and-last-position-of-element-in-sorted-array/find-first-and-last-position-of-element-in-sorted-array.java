class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{solve(nums,target,true),solve(nums,target,false)};
    }
    public int solve(int[] nums, int target,boolean yes){
        int idx = -1;
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                idx = mid;
                if(yes) high = mid-1;
                else low = mid+1;
            }
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return idx;
    }
}