public class Ax_Number_of_unique_XOR_triplets_II {
    
}
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] present = new boolean[MAX];
        int[] values = new int[MAX];
        int m = 0;

        for (int x : nums) {
            if (!present[x]) {
                present[x] = true;
                values[m++] = x;
            }
        }

        boolean[] pair = new boolean[MAX];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                pair[values[i] ^ values[j]] = true;
            }
        }

        boolean[] ans = new boolean[MAX];

        for (int x = 0; x < MAX; x++) {
            if (!pair[x]) continue;
            for (int i = 0; i < m; i++) {
                ans[x ^ values[i]] = true;
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }

        return count;
    }
}