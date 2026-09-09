/*
//APPROACH 1
class Solution {
    public long countCommas(long n) {
        if(n < 999) return 0;
        long comma = 1;
        long low = 1000;
        long res = 0;
        while(low <= n){
            long up = low*1000-1;
            if(up > n) up = n;
            long cntNum = up-low+1;
            res += (cntNum*comma);
            low *= 1000;
            comma ++;
        }
        return res;
    }
}*/
//APPROACH-2
class Solution {
    public long countCommas(long n) {
        long result = 0;
        long lower = 1000;
        while(lower <= n){
            result += (n-lower+1);
            lower *= 1000;
        }
        return result;
    }
}
