class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int k = 0;
        for (int j = 0; j < s2.length(); j++) {
            char ch = s2.charAt(j);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

            if (j - k + 1 > s1.length()) {
                char left = s2.charAt(k);
                map2.put(left, map2.get(left) - 1);
                if (map2.get(left) == 0) map2.remove(left);
                k++;
            }
            if (map1.equals(map2)) return true;
        }
        return false;
    }
}
