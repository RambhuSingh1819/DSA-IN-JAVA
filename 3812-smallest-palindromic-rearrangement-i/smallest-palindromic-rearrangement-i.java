class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] noOfElement = new int[26];     
        for(int i = 0; i < n/2;i++){
            int ele  = s.charAt(i)-'a';
            noOfElement[ele]++;
        }
        StringBuilder sb =new StringBuilder(); 
        for (int i = 0; i < 26; i++) {
            while(noOfElement[i]-- > 0){
                sb.append((char)(i+'a'));
            }
        }
        StringBuilder ans = new StringBuilder(sb.toString());
        if(n % 2 != 0) sb.append(s.charAt(n/2));     
        ans.append(sb.reverse());

        return ans.toString();
    }
}