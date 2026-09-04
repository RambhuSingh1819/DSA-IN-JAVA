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
                if (map.get(key) > 0) {
                    list.add(key);
                    map.put(key, map.get(key) - 1);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}