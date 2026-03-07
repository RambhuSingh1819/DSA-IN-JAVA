class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates,target,0,out,new ArrayList<>());
        return out;
    }
    public void solve(int[] arr, int k , int index, List<List<Integer>> out,List<Integer> ans)
    {
        if(k == 0){
            out.add(new ArrayList<>(ans));
            return;
        }
        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > k) break;

            ans.add(arr[i]);
            solve(arr,k-arr[i],i+1,out,ans);
            ans.remove(ans.size()-1);
        }
    }
}