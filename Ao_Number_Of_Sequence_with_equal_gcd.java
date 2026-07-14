class Solution {
    static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[][] gcd = new int[max + 1][max + 1];
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j <= max; j++) {
                gcd[i][j] = (i == 0) ? j : (j == 0) ? i : gcd(i, j);
            }
        }

        int[][] dp = new int[max + 1][max + 1];
        int[][] next = new int[max + 1][max + 1];

        dp[0][0] = 1;

        for (int x : nums) {

            for (int i = 0; i <= max; i++)
                System.arraycopy(dp[i], 0, next[i], 0, max + 1);

            for (int g1 = 0; g1 <= max; g1++) {
                for (int g2 = 0; g2 <= max; g2++) {

                    int cur = dp[g1][g2];
                    if (cur == 0) continue;

                    int ng1 = gcd[g1][x];
                    next[ng1][g2] += cur;
                    if (next[ng1][g2] >= MOD) next[ng1][g2] -= MOD;

                    int ng2 = gcd[g2][x];
                    next[g1][ng2] += cur;
                    if (next[g1][ng2] >= MOD) next[g1][ng2] -= MOD;
                }
            }

            int[][] temp = dp;
            dp = next;
            next = temp;

            for (int i = 0; i <= max; i++)
                java.util.Arrays.fill(next[i], 0);
        }

        int ans = 0;
        for (int g = 1; g <= max; g++) {
            ans += dp[g][g];
            if (ans >= MOD) ans -= MOD;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
