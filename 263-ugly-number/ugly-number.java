class Solution {
    public boolean isUgly(int n) {
          if (n <= 0) {
            return false;
        }
        int[] uglyNo = {2,3,5};
        for(int i = uglyNo.length-1; i >= 0 ; i--){
            while(n % uglyNo[i] == 0) n = n / uglyNo[i];

        }
        return n == 1;

    }   
}