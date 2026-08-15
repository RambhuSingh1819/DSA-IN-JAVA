class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        if(n < 1) return 1;
        boolean isZero = false;
        int xor = 0;
        for(int ele : nums){
            xor ^= ele;
            if(ele != 0) isZero = true;
        }
        if(xor != 0) return n;
        if(!isZero) return 0;
        return n-1;
    }
}