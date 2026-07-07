class Solution {
    public long sumAndMultiply(int n) {
        // int sum = 0;
        // int num = 0;
        // while(n != 0){
        //     int digit = n % 10;
        //     if(digit != 0){
        //         num =( num * 10 )+  digit;
        //         sum += digit;
        //     }
        //     n /= 10;
        // }
        // int ele = 0;
        // while(num != 0){
        //     int digit = num%10;
        //     ele = (ele * 10) +digit;
        //     num /= 10;
        // } 
        // return ele * sum;


        String s = String.valueOf(n);
        long num = 0;
        long sum = 0;
        for(char ch : s.toCharArray()){
            int digit = ch-'0';
            if(digit != 0){
                num = num * 10 + digit;
                sum += digit;
            }
        }
        return num * sum;
    }
}