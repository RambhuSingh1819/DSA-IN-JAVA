class Solution {
    public int maxProduct(int[] nums) {
        int m1 = 0;
        int m2 = 0;
        for(int ele : nums){
            if(ele >= m1){
                m2 = m1;
                m1 = ele;
            }else if(ele > m2) m2 = ele;
        }
        return (m1-1)*(m2-1);
        
    }
}