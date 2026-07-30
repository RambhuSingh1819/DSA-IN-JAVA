class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int firstMin = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int ele : nums){
            if(ele <= firstMin) firstMin = ele;
            else if(ele <= secMin) secMin  = ele;
            else return true;
        }
        return false;
    }
}