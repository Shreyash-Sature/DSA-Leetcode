class Solution {
    public int Gcd(int a, int b){
        if(b==0){
            return a;
        }
        return Gcd(b, a%b);
    }
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<min){
                min = nums[i];
            }
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return Gcd(max, min);
    }
}