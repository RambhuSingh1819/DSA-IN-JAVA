class Solution {
    public int maxProduct(int n) {
        int fMax= Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        if(n == 10 || n == 20 || n == 30 ||
            n == 40 || n == 50 || n == 60 || 
            n == 70 || n == 80 || n == 90) return 0;

        while(n > 0){
            int temp = n % 10;
            if(temp >= fMax ){
                sMax = fMax;
                fMax = temp;
            }else if(temp > sMax) sMax= temp;
            n = n /10;
        }
        return (int)(sMax*fMax);
        
    }
}