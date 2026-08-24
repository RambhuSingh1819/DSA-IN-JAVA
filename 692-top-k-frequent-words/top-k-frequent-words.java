class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }
            return a.compareTo(b);
        });
        for (String word : map.keySet()) {
            pq.add(word);
        }

        List<String> ans = new ArrayList<>();
        while (k > 0) {
            ans.add(pq.poll());
            k--;
        }

        return ans;
    }
}