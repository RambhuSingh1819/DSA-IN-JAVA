class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while(j < n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.get(nums[j]) > k){
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }
            int len = j - i + 1;
            ans = Math.max(ans,len);
            j++;
        }
        return ans;
    }
}