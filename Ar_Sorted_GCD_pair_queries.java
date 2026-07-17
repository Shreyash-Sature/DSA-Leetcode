class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] exact = new long[max + 1];

        // Inclusion-Exclusion from largest GCD to smallest
        for (int g = max; g >= 1; g--) {
            long cnt = 0;
            for (int m = g; m <= max; m += g)
                cnt += freq[m];

            long pairs = cnt * (cnt - 1) / 2;

            for (int m = g + g; m <= max; m += g)
                pairs -= exact[m];

            exact[g] = pairs;
        }

        // Prefix counts of sorted gcdPairs
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++)
            prefix[i] = prefix[i - 1] + exact[i];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // 1-based position

            int lo = 1, hi = max;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (prefix[mid] >= k)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            ans[i] = lo;
        }

        return ans;
    }
}