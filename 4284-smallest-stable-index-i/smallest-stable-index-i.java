class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] min = new int[n];
        min[n-1] = nums[n-1];
        for(int i = n-2; i >= 0;i--){
            min[i] = Math.min(nums[i],min[i+1]);
        }
        int max = nums[0];
        for(int i = 1; i < n;i++){
            max = Math.max(nums[i],max);
            nums[i] = max;
        }
        int ans = -1;
        for(int i = 0; i < n; i++){
            int val = nums[i] - min[i];
            if(val <= k) return i;
        }
        return ans;
    }
}