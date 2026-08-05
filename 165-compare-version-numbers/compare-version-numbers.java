class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n1 = version1.length(), n2 = version2.length();
        while(i < n1 || j < n2){
            int NO1 = 0;
            int NO2 = 0;
            while(i < n1 && version1.charAt(i) != '.'){
                NO1 = NO1 * 10 + (version1.charAt(i)-'0');
                i++;
            }
            i++;
            while(j < n2 && version2.charAt(j) != '.'){
                NO2 = NO2 * 10 + (version2.charAt(j)-'0');
                j++;
            }
            j++;

            if(NO1 < NO2) return -1;
            else if(NO1 > NO2) return 1;
        }
        return 0;
    }
}