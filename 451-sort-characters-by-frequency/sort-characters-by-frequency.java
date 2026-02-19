import java.util.*;

class Solution {
    public String frequencySort(String s) {

        int[] arr = new int[128];

        for (char ch : s.toCharArray()) {
            arr[ch]++;
        }

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            if (arr[i] > 0) {
                list.add((char) i);
            }
        }

        list.sort((a, b) -> {
            if (arr[b] == arr[a]) 
                return a - b;   
            return arr[b] - arr[a];
        });

        // Build result (repeat characters)
        StringBuilder sb = new StringBuilder();

        for (char ch : list) {
            int freq = arr[ch];
            while (freq-- > 0) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
