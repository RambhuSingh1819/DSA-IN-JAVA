class Solution {
    public int minimumPushes(String word) {

       int[] freq = new int[26];
        char[] chars = word.toCharArray();
        for(char c : chars){
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int cost = 0;
        int range = 0;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            cost += freq[i] * (range / 8 + 1);
            range++;
        }

        return cost;
    }
}