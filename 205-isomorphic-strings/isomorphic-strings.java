class Solution {
    public boolean isIsomorphic(String s, String t) {
        // if(s.length() != t.length()) return false;
        // HashMap<Character,Character> map = new HashMap<>();
        // Set<Character> set = new HashSet<>();
        // for(int i = 0; i < s.length(); i++){
        //     char c1 = s.charAt(i);
        //     char c2 = t.charAt(i);

        //     if(map.containsKey(c1)){
        //         if(map.get(c1) != c2) return false;
        //     }else {
        //         if(set.contains(c2)) return false;
        //         map.put(c1,c2);
        //         set.add(c2);
        //     }

        // }
        // return true;

        int[] strs= new int[256];
        int[] strt= new int[256];
        int n= s.length();
        if(n!= t.length()) return false;
        for(int i=0; i<n; i++){
            char a= s.charAt(i);
            char b= t.charAt(i);
            if(strs[a]!= strt[b]) return false;
            strs[a]= i+1;
            strt[b]= i+1;
        }
        return true;
    }
}