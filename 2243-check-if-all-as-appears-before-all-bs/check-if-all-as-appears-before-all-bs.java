class Solution {
    public boolean checkString(String s) {
        int it = s.charAt(0)-'a';
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i)-'a' < it){
                return false;
            }
            it = s.charAt(i)-'a';
        }
      return true;
    }
}