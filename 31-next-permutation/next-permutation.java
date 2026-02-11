import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            reverse(nums,0,n-1);
            return ;
        }
        for(int i = n-1; i > idx; i--){
            if(nums[i] > nums[idx]){
                swap(nums,idx,i);
                break;
            }
        }
        reverse(nums,idx+1,n-1);
    }
    public void swap(int[] nums,int st,int end){
        int temp = nums[st];
        nums[st] = nums[end];
        nums[end] = temp;
        return;
    }
    public void reverse(int[] nums,int st,int end){
         while(st < end) swap(nums,st++,end--);
    }
       
}