class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
        first(nums, 0, nums.length - 1, target,true),
        first(nums, 0, nums.length - 1, target,false)
        };
    }

    // Find first occurrence
    public int first(int[] nums, int low, int high, int target,boolean first) {
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {

                if(first){
                    index = mid;
                    high = mid - 1; 
                }
                else{
                    index = mid;
                    low = mid + 1;
                }
                // move left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
