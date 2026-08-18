class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : time){
            int num = 60-(ele%60);
            num %= 60;
            if(map.containsKey(num))cnt += map.get(num);

            map.put((ele%60),map.getOrDefault((ele%60),0)+1);
        }

        return cnt;
    }
}