import java.util.Stack;

public class At_Smallest_Subsequence_of_distinct_character {
    public String smallestSubsequence(String s) {

        int[] last = new int[26];

        // Store last occurrence
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Already present
            if (visited[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && last[stack.peek() - 'a'] > i) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }
} 
