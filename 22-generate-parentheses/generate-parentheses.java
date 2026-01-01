class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(n ,n,"",result);
        return result;
    }
    public void solve(int open, int close , String ans , List<String> result){
        if(open == 0 && close == 0){
            result.add(ans);
            return;
        }
        if(open != 0){
            
            solve(open-1,close,ans+'(',result);
        }
        if(close > open){
            solve(open,close-1,ans+')',result);
        }
        return ;
    }
}