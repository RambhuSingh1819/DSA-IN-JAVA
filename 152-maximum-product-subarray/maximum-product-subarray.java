class Solution {
    public int maxProduct(int[] nums) {
        int maxPro = nums[0];
        int minPro = nums[0];
        int result = nums[0];
         for(int i = 1; i < nums.length; i++){
            int ele = nums[i];
            if(ele < 0){
                int temp = maxPro;
                maxPro = minPro;
                minPro = temp;
            }
            maxPro = Math.max(ele, maxPro * ele);
            minPro = Math.min(ele, minPro * ele);

            result = Math.max(result, maxPro);
        }
        return result;
    }
}