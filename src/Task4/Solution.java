package Task4;

public class Solution {
    public static String openParenthesis(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (Character.isDigit(s.charAt(j))) ++j;
                int k = Integer.parseInt(s.substring(i, j));
                int cnt = 1;
                i = j + 1;
                while (cnt > 0 && ++j < s.length()) {
                    if (s.charAt(j) == '(') ++cnt;
                    else if (s.charAt(j) == ')') --cnt;
                }
                String word = openParenthesis(s.substring(i, j));
                while (k-- > 0) sb.append(word);
                i = j;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

