class Solution {
    public String largestOddNumber(String num) {
        int j = 0;
        while(num.charAt(j) == '0') j++;
        for(int i = num.length()-1; i >= 0 ; i--){
            if((num.charAt(i)-'0')% 2 == 1) return num.substring(j,i+1);
        }
        return "";
        
    }
}