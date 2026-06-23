public class Ac_Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return n;
        }

        int k = 2;

        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
