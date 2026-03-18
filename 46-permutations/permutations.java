class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), res,new boolean [nums.length]);

        return res;
    }

    void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> res,boolean used[]){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                curr.add(nums[i]);
                backtrack(nums,curr,res,used);
                curr.remove(curr.size()-1);
                used[i] = false;
            }
        }
    }
}