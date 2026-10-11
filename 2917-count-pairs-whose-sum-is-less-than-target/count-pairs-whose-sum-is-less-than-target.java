class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);

        int i = 0;
        int j = nums.size() - 1;
        int cnt = 0;

        while (i < j) {
            if (nums.get(i) + nums.get(j) < target) {
                cnt += j - i;
                i++;
            } else {
                j--;
            }
        }

        return cnt;
    }
}