public class Ae_Reverse_Words_in_String {
    
}
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);

        int n = sb.length();
        int i = n - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (sb.charAt(i) != ' ') {
                i--;
            } else if (i == j) {
                sb.deleteCharAt(i);
                i--;
                j--;
            } else {
                sb.append(sb.substring(i, j + 1));
                sb.delete(i, j + 1);
                j = i - 1;
                i = i - 1;
            }
        }

        if (i < 0 && j >= 0) {
            sb.append(' ').append(sb.substring(0, j + 1));
            sb.delete(0, j + 1);
        }

        while (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}