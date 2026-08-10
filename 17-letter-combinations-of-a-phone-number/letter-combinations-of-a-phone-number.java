class Solution {
    public String letter(int n){
        switch(n){
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5 : return "jkl";
            case 6 : return "mno";
            case 7 : return "pqrs";
            case 8 : return "tuv";
            case 9 : return "wxyz";
            default :  return "";
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
       if(digits == null || digits.length() == 0) return ans;
        solve(digits,ans,"",0);
        return ans;
        
    }
    public void solve(String digits, List<String> ans, String s , int idx){
        if(idx == digits.length()) {
            ans.add(s);
            return;
        } 
        int num = digits.charAt(idx)-'0';
        String letters = letter(num);
        for(int i = 0; i < letters.length(); i++){
            solve(digits,ans,s+letters.charAt(i),idx+1);
        }
    }
}