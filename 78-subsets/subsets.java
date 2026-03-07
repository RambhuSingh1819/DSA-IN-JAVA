class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
         solve(nums,0,ans,new ArrayList<Integer>());   
         return ans;
    }
    public void solve(int[] nums,int idx , List<List<Integer>> ans,List<Integer> list){
        
        if(idx == nums.length){
            ans.add(new ArrayList(list));
            return ;
        }
        list.add(nums[idx]);
        solve(nums,idx+1,ans,list);
        
        list.remove(list.size()-1);
        solve(nums,idx+1,ans,list);

    }
}