import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Convert to Integer array for sorting
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        
        // Step 3: Custom sort
        Arrays.sort(arr, (a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return b - a;  // Decreasing value if frequency same
            }
            return map.get(a) - map.get(b); // Increasing frequency
        });
        
        // Step 4: Convert back to int[]
        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }
}
