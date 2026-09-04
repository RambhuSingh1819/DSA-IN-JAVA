class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] min = new int[n];
        min[n-1] = nums[n-1];
        for(int i = n-2; i >= 0;i--){
            //FIND ALL THE MIN VALUE FROM LAST AND STORE IT 
            min[i] = Math.min(nums[i],min[i+1]);
        }
        int max = nums[0];
        for(int i = 1; i < n;i++){
            //FIND THE MAX VALUE FROM FROM STARTING AND STORE IT
            max = Math.max(nums[i],max);
            nums[i] = max;
        }
        for(int i = 0; i < n; i++){
            //IF BASE CONDITION MEET RETURN
            int val = nums[i] - min[i];
            if(val <= k) return i;
        }
        // IF NO MIN VALUE THEN K THEN RETURN -1
        return -1;
    }
}