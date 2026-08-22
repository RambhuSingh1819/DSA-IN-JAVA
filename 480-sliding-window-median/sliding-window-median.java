import java.util.Comparator;
import java.util.TreeSet;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        Comparator<Integer> comparator = (a, b) -> {
            if (nums[a] != nums[b]) {
                return Integer.compare(nums[a], nums[b]);
            }
            return Integer.compare(a, b);
        };
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        

        TreeSet<Integer> right = new TreeSet<>(comparator);

        double[] ans = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            left.add(i);
            right.add(left.pollFirst());
            
            if (left.size() < right.size()) {
                left.add(right.pollFirst());
            }
            if (i >= k - 1) {
            
                if (k % 2 == 0) {
                    ans[i - k + 1] = ((double) nums[left.first()] + (double) nums[right.first()]) / 2.0;
                } else {
                    ans[i - k + 1] = (double) nums[left.first()];
                }
                int removeIdx = i - k + 1;
                if (!left.remove(removeIdx)) {
                    right.remove(removeIdx);
                }
            }
        }
        
        return ans;
    }
}