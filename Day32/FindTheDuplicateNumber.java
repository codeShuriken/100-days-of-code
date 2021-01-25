class FindTheDupliacateNumber {
    public static void main(String[] args) {
        int[] A = {1,3,4,2,2};
        System.out.println(findDuplicate(A));
        int[] B = {3,1,3,4,2};
        System.out.println(findDuplicate(B));
    }

    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i){
            int num = Math.abs(nums[i]);
            --num;
            if (nums[num] < 0)return num+1;
            nums[num] = -nums[num];
        }
        return -1;
    }
}