class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] ch = s.toCharArray();
        solve(0,ch,ans);
        return ans;
    }
    public void solve(int idx, char[] ch , List<String> ans ){
        if(idx == ch.length){
            ans.add(new String(ch));
            return ;
        }
        char check = ch[idx];
        if(Character.isDigit(check)){
            solve(idx+1,ch,ans);
        }else{
            ch[idx] = Character.toUpperCase(check);
            solve(idx+1,ch,ans);
            ch[idx] = Character.toLowerCase(check);
            solve(idx+1,ch,ans);
        }
    }
}