class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n,n,"",ans);
        return ans;
    }
    public void solve(int open, int close, String s, List<String> ans){
        if(open == 0 && close == 0){
            ans.add(s);
            return;
        }
        if(open != 0) solve(open-1,close,s+'(',ans);
        if(close > open) solve(open,close-1,s+')',ans);

    }
}