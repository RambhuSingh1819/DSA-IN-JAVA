class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        Arrays.sort(nums1);

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> Integer.compare(nums2[a], nums2[b]));

        int[] ans = new int[n];
        int l = 0, r = n - 1;

        for (int i = 0; i < n; i++) {
            if (nums1[i] > nums2[idx[l]]) {
                ans[idx[l]] = nums1[i];
                l++;
            } else {
                ans[idx[r]] = nums1[i];
                r--;
            }
        }

        return ans;
    }
}