class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        
        List<List<Integer>> ans = new ArrayList<>();
        if(n == 0 || k > n) return ans;
        solve(0,arr,k,n,ans,new ArrayList<>());
        return ans;
    }
    public void solve(int idx, int[] arr, int k , int n ,List<List<Integer>> ans, List<Integer> temp){
        if(k == 0 && n == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i < arr.length;i++){
            if(arr[i] > n) break;
            temp.add(arr[i]);
            solve(i+1,arr,k-1,n-arr[i],ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}