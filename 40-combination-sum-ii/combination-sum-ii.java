import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(0, candidates, target, new ArrayList<>(), res);

        return res;
    }

    void backtrack(int index, int[] arr, int target, List<Integer> curr, List<List<Integer>> res){

        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index;i<arr.length;i++){

            if(i>index && arr[i]==arr[i-1])
                continue;

            if(arr[i] > target)
                break;

            curr.add(arr[i]);

            backtrack(i+1, arr, target-arr[i], curr, res);

            curr.remove(curr.size()-1);
        }
    }
}