// import java.util.Arrays;

// class Solution {
//     public void rotate(int[] nums, int k) {
//         int len = nums.length;
//         if (len == 0 || k % len == 0) return;
//         k = k % len;
//         int[] temp = new int[k];
//         for (int i = 0; i < k; i++) {
//             temp[i] = nums[len - k + i];
//         }
//         for (int i = len - k - 1; i >= 0; i--) {
//             nums[i + k] = nums[i];
//         }
//         for (int i = 0; i < k; i++) {
//             nums[i] = temp[i];
//         }
//         System.out.print(Arrays.toString(nums) + " ");
//     }
// }
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // handle k > n
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}