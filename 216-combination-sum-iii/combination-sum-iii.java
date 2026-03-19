class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> out = new ArrayList<>();
        solve(arr,out,0,new ArrayList<>(),k,n);
        return out;
    }
     public void solve(int[] arr,List<List<Integer>> out,int index,List<Integer> ans, int k,int n){
        if(k == 0 && n == 0){
            out.add(new ArrayList(ans));
            return;
        }
        if(k < 0 || n < 0) return;
        for(int i = index; i < arr.length; i++){
            if(arr[i] > n) break;
            ans.add(arr[i]);
            solve(arr,out,i+1,ans,k-1,n-arr[i]);
            ans.remove(ans.size()-1);
        }
    }
}