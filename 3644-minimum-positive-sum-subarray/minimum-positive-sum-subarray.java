class Solution {
    int ans = Integer.MAX_VALUE;
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        ans = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            solve(nums,i);
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    public void solve(List<Integer> nums,int k){
        int n = nums.size();
        int j = 0;
        int sum = 0;
        int size = 0;
        for(int i = 0; i < n; i++){
            sum += nums.get(i);
            size++;
            if(size > k){
                sum -= nums.get(j);
                j++;
                size--;
            }
            if(size == k && sum > 0) ans = Math.min(ans,sum);
        }
    }
}