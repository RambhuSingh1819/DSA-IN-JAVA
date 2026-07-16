class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int max = nums[0];
        int[] prefixGCD = new int[n];

        prefixGCD[0] = nums[0];

        for(int i = 1; i < n; i++){
            if(nums[i] > max) max = nums[i];
            prefixGCD[i] = gcd(nums[i],max);
        }

        Arrays.sort(prefixGCD);
       

       int i = 0;
       int j = n-1;


         if(prefixGCD[i] == prefixGCD[j]) return (long)(n/2)*prefixGCD[i];

       while(i < j){
            if(i == j) continue;
            sum += (gcd(prefixGCD[i++],prefixGCD[j--]));
       }

        return sum;
    }


    public int gcd(int a , int b){
        while(b != 0){
            int tem = b;
            b = a % b;
            a = tem;
        }
        return a;
    }
}