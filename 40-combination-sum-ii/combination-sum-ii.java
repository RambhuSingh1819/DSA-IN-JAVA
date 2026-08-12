class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        if (n == 0)
            return ans;
        solve(0, new ArrayList<>(), ans, candidates, target);
        return ans;
    }

    public void solve(int idx, ArrayList<Integer> temp,
            List<List<Integer>> ans, int[] arr, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > k)
                break;
            temp.add(arr[i]);
            solve(i+1, temp, ans, arr, k - arr[i]);
            temp.remove(temp.size() - 1);
        }
    }
}