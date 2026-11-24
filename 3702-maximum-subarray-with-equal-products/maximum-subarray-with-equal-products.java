class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int len = 0;
        for(int i = 0; i < n; i++){
            int currPro = nums[i];
            int currGCG = nums[i];
            int currLCM = nums[i];
            for(int j = i+1; j < n; j++){
                currPro *= nums[j];
                currGCG = GCG(currGCG,nums[j]);
                currLCM = LCM(currLCM,nums[j]);

                if(currPro == (currGCG * currLCM)){
                    len = Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }
    public int GCG(int a, int b){
        return b == 0 ? a : GCG(b,a%b);
    }
    public int LCM(int a, int b){
        return (a/GCG(a,b))*b;
    }
}