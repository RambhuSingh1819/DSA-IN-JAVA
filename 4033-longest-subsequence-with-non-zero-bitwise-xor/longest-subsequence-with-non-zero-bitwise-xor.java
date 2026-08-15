class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        if(n < 1) return 1;
        int cntZero = 0;
        int xor = 0;
        for(int ele : nums){
            xor ^= ele;
            if(ele == 0) cntZero++;
        }
        if(xor != 0) return n;
        if(cntZero == n) return 0;
        return n-1;
    }
}