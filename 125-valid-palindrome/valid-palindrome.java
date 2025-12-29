class Solution {
    public boolean isPalindrome(String s) {
        String cs = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = cs.length()-1;
        while(i <= j){
            if(cs.charAt(i) != cs.charAt(j)){
            return false;
            }
            i++;
            j--;
        }
        return true;
    }
}