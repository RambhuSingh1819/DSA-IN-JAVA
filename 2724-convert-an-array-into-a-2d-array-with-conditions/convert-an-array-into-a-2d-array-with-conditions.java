class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for (int ele : nums) {
            int freq = map.getOrDefault(ele, 0) + 1;
            map.put(ele, freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        for (int i = 1; i <= maxFreq; i++) {
            List<Integer> list = new ArrayList<>();
            for (Integer key : map.keySet()) {
                if (map.get(key) >= i) {
                    list.add(key);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}