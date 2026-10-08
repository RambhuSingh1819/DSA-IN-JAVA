class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] arr = new boolean[n+1];
        for(int num: nums){
            if(num >= 0 && num < n+1){
                arr[num] = true;
            }
        }
        for(int i = 1; i <= n; i++){
            if(!arr[i]) return i;
        }

        return n+1;
    }
}