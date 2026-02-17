class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String ans = goal+goal;
        return ans.contains(s);
        
    }
}