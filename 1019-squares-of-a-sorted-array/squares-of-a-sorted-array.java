class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int low = 0;
        int high = n-1;
        int idx = n-1;
        while(low <= high){
            int leftSq = nums[low] * nums[low];
            int rightSq = nums[high] * nums[high];
            if(leftSq > rightSq){
                ans[idx] = leftSq;
                low++;
            }else {
                ans[idx] = rightSq;
                high--;
            }
            idx--;
        }
        return ans;
        
    }
}