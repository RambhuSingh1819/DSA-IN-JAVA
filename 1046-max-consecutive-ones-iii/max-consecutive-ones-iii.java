class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int zero = 0;
        int maxLen = 0;

        while(r < n){
            if(nums[r] == 0) zero++;

            while(zero > k){
                if(nums[l] == 0) zero--;
                l++; 
            }

            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);

            r++;
        }
        return maxLen;
    }
}