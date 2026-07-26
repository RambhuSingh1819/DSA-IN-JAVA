class Solution {
    public int maximumProduct(int[] nums) {
        int n1 = Integer.MIN_VALUE;
        int n2 = Integer.MIN_VALUE;
        int n3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int ele : nums){
            if(ele >= n1){
                n3 = n2;
                n2 = n1;
                n1 = ele;
            }else if(ele >= n2){
                n3 = n2;
                n2 = ele;
            }else if(ele >= n3){
                n3 = ele;
            }
            if (ele <= min1) {
                min2 = min1;
                min1 = ele;
            } else if (ele <= min2) {
                min2 = ele;
            }
        }

        return Math.max((n1*n2*n3),(min1*min2*n1));
    }
}