class Solution {
    public int countWays(List<Integer> nums) {
        int n = nums.size();
        Collections.sort(nums);
        int cnt = 0;
        if(0 < nums.get(0)) cnt++;
        for(int k = 1; k < n; k++){
            if(k > nums.get(k-1) && k < nums.get(k)) cnt++;
        }
        if(n > nums.get(n-1)) cnt++;

        return cnt;
        
    }
}