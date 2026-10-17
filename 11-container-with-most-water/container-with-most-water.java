class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        if(length < 2) return 0;

        int low = 0;
        int high = length-1;
        while(height[low] == 0) low++;
        while(height[high] == 0) high--;
        if(low >= high) return 0;
        int ans = 0;
        while(low < high){
            int width = high - low;
            int size = Math.min(height[low],height[high]);
            int area = width * size;
            ans = Math.max(ans,area);
            if(height[low] > height[high]) high--;
            else low ++;
        }  
        return ans;   
    }
}