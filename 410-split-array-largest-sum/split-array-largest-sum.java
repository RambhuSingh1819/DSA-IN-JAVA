class Solution {
    public boolean check(int arr[],int mid,int k){
        int sum=0;
        int partitions=1;

        for(int i:arr){
            if(sum+i<=mid){
                sum+=i;
            }
            else{
                partitions++;
                sum=i;
            }
        }

        return partitions<=k;
    }

    public int splitArray(int[] arr, int k) {
        int low=arr[0];
        int high=arr[0];

        int ans=-1;

        for(int i=1;i<arr.length;i++){
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }

        while(low<=high){
            int mid=low+(high-low)/2;

            if(check(arr,mid,k)){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }

        return ans;
    }
}