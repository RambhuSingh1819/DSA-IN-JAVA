class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        String stringRange = "123456789";

        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();

        for(int length = lowLength; length <= highLength; length++){

            for(int st= 0; st <= 9-length; st++){
                String s = stringRange.substring(st,st+length);
                int num = Integer.parseInt(s);

                if(num >= low && num <= high) list.add(num);
            }
        }
        return list;
    }
}