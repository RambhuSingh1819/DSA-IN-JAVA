import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Integer[] newnums = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) +  1);
            newnums[i] = nums[i];
        }

        Arrays.sort(newnums, (n1, n2) -> {
            if(map.get(n1) != map.get(n2)) {
                return map.get(n1) - map.get(n2);
            } else {
                return n2 - n1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newnums[i];
        }
        return nums;
    }
}
