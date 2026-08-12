class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,new ArrayList(),ans,candidates, target);
        return ans;
    }
    public void solve(int idx, ArrayList<Integer> temp , List<List<Integer>> ans, int[] arr,int k){
        
        if(k == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i < arr.length; i++){
            if(arr[i] > k) break;
            temp.add(arr[i]);
            solve(i,temp,ans,arr,k-arr[i]);
            temp.remove(temp.size()-1);
        }
    }
}