class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int ele : nums){
            if(ele > max) max = ele;
            if(ele < min) min = ele;
        }
        return (long)(max-min)*k;
    }
}