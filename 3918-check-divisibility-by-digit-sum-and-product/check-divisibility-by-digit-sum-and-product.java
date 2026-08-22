class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int pro = 1;
        int num = n;
        while(num > 0){
            int temp = num % 10;
            sum += temp;
            pro *= temp;
            num /= 10;
        }
        int t = sum+pro;
        if(n %  t != 0) return false;
        return true;
        
    }
}