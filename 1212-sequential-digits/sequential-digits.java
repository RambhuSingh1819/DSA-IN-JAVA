class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        String str = "123456789";

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for(int len = lowLen; len <= highLen; len++){
            for(int i = 0; i <= 9-len; i++){
                String s = str.substring(i,i+len);
                int num = Integer.parseInt(s);

                if(num >= low && num <= high) list.add(num);
            }
        }
        return list;
    }
}