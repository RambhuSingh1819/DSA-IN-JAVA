class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break;

            int j = i;

            // Find word start
            while (i >= 0 && s.charAt(i) != ' ') i--;

            // Append word
            sb.append(s.substring(i + 1, j + 1));
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
