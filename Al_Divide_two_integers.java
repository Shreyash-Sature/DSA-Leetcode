public class Al_Divide_two_integers {
    
}
class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both to negative
        if (dividend > 0)
            dividend = -dividend;

        if (divisor > 0)
            divisor = -divisor;

        int quotient = 0;

        while (dividend <= divisor) {

            int temp = divisor;
            int multiple = -1;

            while (temp >= (Integer.MIN_VALUE >> 1)
                    && dividend <= (temp << 1)) {

                temp <<= 1;
                multiple <<= 1;
            }

            dividend -= temp;
            quotient += multiple;
        }

        return negative ? quotient : -quotient;
    }
}