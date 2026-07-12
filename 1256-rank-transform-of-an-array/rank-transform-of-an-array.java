class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);

        Map<Integer,Integer> map = new HashMap<>();
        int rank = 1;
        for(int ele : temp){
            if(!map.containsKey(ele)){
                map.put(ele,rank);
                rank++;
            }
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
        
    }
}