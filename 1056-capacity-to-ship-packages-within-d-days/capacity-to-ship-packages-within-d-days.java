class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int total =0;
        int maxi = Integer.MIN_VALUE;
 for(int weight:weights){
            total+=weight;
            maxi = Math.max(maxi,weight);
        }
int low = Math.max(maxi,total/days);
int high = maxi*(int)Math.ceil((double)weights.length/days);
    while(low <= high){
        int mid = low + (high-low)/2;
        int NOD = Days(weights,mid);
            if(NOD <= days){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
    }
    return low;

    }
    public int Days(int[] weights, int capacity){
         int days = 1, remaining = capacity;
        for (int weight : weights) {
            if (remaining < weight) {
                days++;
                remaining = capacity;
            }
            remaining -= weight;
        }
        return days;   
    }
}