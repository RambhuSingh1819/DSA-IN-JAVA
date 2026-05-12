class Solution {
    public int commonFactors(int a, int b) {
        int cF = HCF(a,b);
        int cnt = 1;
        for(int i = 2; i <= cF; i++){
            if(a % i == 0 && b % i == 0) cnt++;
        }
        return cnt;
    }
    public int HCF(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}