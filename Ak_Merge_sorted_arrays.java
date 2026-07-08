class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left = 0;
        int right = 0;
        int i = 0;

        int[] arr = new int[m + n];

        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                arr[i++] = nums1[left++];
            } else {
                arr[i++] = nums2[right++];
            }
        }

        while (left < m) {
            arr[i++] = nums1[left++];
        }

        while (right < n) {
            arr[i++] = nums2[right++];
        }

        for (int k = 0; k < m + n; k++) {
            nums1[k] = arr[k];
        }
    }
}