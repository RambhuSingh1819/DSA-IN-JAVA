class Solution {
    public int maxProfit(int[] prices) {
        int minimumPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int ele : prices){
            if(ele < minimumPrice) minimumPrice = ele;
            profit = Math.max(profit,ele - minimumPrice);
        }
        return profit;
        
    }
}