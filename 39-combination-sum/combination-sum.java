class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        solve(0, candidates, target, new ArrayList<>(), res);

        return res;
    }

    void solve(int index, int[] arr, int target, List<Integer> curr, List<List<Integer>> res){

        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(index == arr.length)
            return;

        if(arr[index] <= target){
            curr.add(arr[index]);
            solve(index, arr, target-arr[index], curr, res);
            curr.remove(curr.size()-1);
        }

        solve(index+1, arr, target, curr, res);
    }
}