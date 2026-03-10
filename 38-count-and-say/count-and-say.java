class Solution {
     public String countAndSay(int n) {
        return rle("1", n-1);
    }

    public String rle(String n, int l) {
        if(l==0)return n;
        int i = 0;
        StringBuilder k = new StringBuilder();
        while (i < n.length()) {
            int len = 1;
            while (i + 1 < n.length() && n.charAt(i + 1) == n.charAt(i)) {
                len++;
                i++;
            }
            k.append(len);
            k.append(n.charAt(i++));
        }
        return rle(k.toString(), l-1);
    }
}