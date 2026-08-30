class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = 0;
        int maxIdx = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < min){
                min = nums[i];
                minIdx = i;
            }
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
        }
        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        // 3 possible strategies
        int bothFromLeft = right + 1;
        int bothFromRight = n - left;
        int fromBothEnds = (left + 1) + (n - right);

        return Math.min(bothFromLeft, Math.min(bothFromRight, fromBothEnds));
    }
}