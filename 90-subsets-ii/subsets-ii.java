class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list  = new ArrayList<>();
        Arrays.sort(nums);
        solution(nums,0,list,new ArrayList<Integer>());
        return list;
        
    }
    public void solution(int [] nums, int idx, List<List<Integer>> list, List<Integer> ans){
       list.add(new ArrayList<>(ans));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
        ans.add(nums[i]);
        solution(nums,i+1,list,ans);
        ans.remove(ans.size()-1);
        }
    }
}