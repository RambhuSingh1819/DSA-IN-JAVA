class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> list : responses) {
            HashSet<String> set = new HashSet<>(list);
            for (String s : set) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        String ans = "";
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int freq = entry.getValue();
            if (freq > maxFreq ||
                (freq == maxFreq && key.compareTo(ans) < 0)) {

                maxFreq = freq;
                ans = key;
            }
        }
        return ans;
    }
}