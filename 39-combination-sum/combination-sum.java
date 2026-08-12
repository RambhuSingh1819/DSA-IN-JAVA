class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,new ArrayList(),ans,candidates, target);
        return ans;
    }
    public void solve(int i, ArrayList<Integer> temp , List<List<Integer>> ans, int[] arr,int k){
        if(i == arr.length) return;
        if(k == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(arr[i] <= k) {
            temp.add(arr[i]);
            solve(i,temp,ans,arr,k-arr[i]);
            temp.remove(temp.size()-1);
        }
        solve(i+1,temp,ans,arr,k);
    }
}