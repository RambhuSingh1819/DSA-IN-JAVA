class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), res);

        return res;
    }

    void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> res){

        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int num : nums){

            if(curr.contains(num))
                continue;

            curr.add(num);

            backtrack(nums, curr, res);

            curr.remove(curr.size()-1);
        }
    }
}