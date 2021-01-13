class MaxContSubArray {
    public static void main(String[] args) {
        int[] A = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("The largest contiguous subarray sum is: " + maxSubArray(A));
    } 

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums){
            curSum = Math.max(curSum + num, num);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}