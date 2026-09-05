class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] smallEle  = new int[n];
        smallEle[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            smallEle[i] = Math.min(smallEle[i+1],nums[i]);
        }
        for(int i = 1; i < n; i++){
            nums[i] = Math.max(nums[i],nums[i-1]);
        }
        for(int i = 0; i < n; i++){
            if(nums[i]-smallEle[i] <= k)
            return i;
        }
        return -1;
    }
}