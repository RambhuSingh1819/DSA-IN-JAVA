import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        int freq[]=new int[201];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]+100]++;
        }
        Integer []arr=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
         Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {

                int f1 = freq[a + 100];
                int f2 = freq[b + 100];

                if (f1 < f2) return -1;     
                if (f1 > f2) return 1;

                return b - a;               
            }
        });

       
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;

    }
}
