import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int totalN = nums.length;
        int n = totalN / 2;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        List<Integer>[] left = new ArrayList[n + 1];
        List<Integer>[] right = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }
        int totalSubsets = 1 << n;
        for (int mask = 0; mask < totalSubsets; mask++) {
            int leftSum = 0, rightSum = 0, count = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    leftSum += nums[i];
                    rightSum += nums[i + n]; 
                    count++;
                }
            }
            left[count].add(leftSum);
            right[count].add(rightSum);
        }
        for (int i = 0; i <= n; i++) {
            Collections.sort(right[i]);
        }
        
        int minDiff = Integer.MAX_VALUE;
        int target = totalSum / 2;

        for (int k = 0; k <= n; k++) {
            List<Integer> leftList = left[k];
            List<Integer> rightList = right[n - k];
            
            for (int a : leftList) {
                int expectedB = target - a;
                
                int idx = Collections.binarySearch(rightList, expectedB);
                
                if (idx < 0) {
                    idx = -(idx + 1); 
                }
                if (idx < rightList.size()) {
                    int b = rightList.get(idx);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (a + b)));
                }
                
                if (idx > 0) {
                    int b = rightList.get(idx - 1);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (a + b)));
                }
            }
        }
        
        return minDiff;
    }
}