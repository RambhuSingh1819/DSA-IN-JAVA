class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return AtMost(nums,k)-AtMost(nums,k-1);
    }
    private int AtMost(int []nums,int k){
        int left=0;
        int count=0;
        int []freq=new int[nums.length+1];
        for(int right=0;right<nums.length;right++){
            if(freq[nums[right]]==0)k--;
            freq[nums[right]]++;
            while(k<0){
                freq[nums[left]]--;
                if(freq[nums[left]]==0)k++;
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}