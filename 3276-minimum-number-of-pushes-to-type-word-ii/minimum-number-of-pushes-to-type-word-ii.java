class Solution {
    public int minimumPushes(String word) {

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Integer> freq = new ArrayList<>(map.values());
        freq.sort((a, b) -> Integer.compare(b, a));

        int ans = 0;

        for (int i = 0; i < freq.size(); i++) {
            int pushes = (i / 8) + 1;
            ans += freq.get(i) * pushes;
        }

        return ans;
    }
}