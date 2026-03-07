class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list  = new ArrayList<>();
        Arrays.sort(nums);
        solution(nums,0,list,new ArrayList<Integer>());
        return list;
        
    }
    public void solution(int [] nums, int idx, List<List<Integer>> list, List<Integer> ans){
        if(idx == nums.length){
            if(!list.contains(ans))list.add(new ArrayList(ans));
            return ;
        }
        ans.add(nums[idx]);
        solution(nums,idx+1,list,ans);
        ans.remove(ans.size()-1);
        solution(nums,idx+1,list,ans);
    }
}