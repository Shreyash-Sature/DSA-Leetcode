public class Ap_GCD_of_Odd_Even_Sums {
    
}
class Solution {

    public int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public int gcdOfOddEvenSums(int n) {
        int sumEven = n * (n + 1);
        int sumOdd = n * n;

        return GCD(sumOdd, sumEven);
    }
}
