class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int ans = 0;
        for(int[] arr : boxTypes){
            int boxNo = arr[0];
            int boxUnit = arr[1];
            int take = Math.min(truckSize,boxNo);
            ans += take * boxUnit;
            truckSize -= take;
            if(truckSize == 0) break;
        }
        return ans;
    }
}