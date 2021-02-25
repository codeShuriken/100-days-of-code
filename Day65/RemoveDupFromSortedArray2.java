import java.util.Arrays;

class RemoveDupFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums  = {1,1,1,2,2,3};
        int index = removeDuplicates(nums);
        System.out.println(index);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, index)));

        int[] nums1 = {0,0,1,1,1,1,2,3,3};
        int index1  = removeDuplicates(nums1);
        System.out.println(index1);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums1, 0, index1)));

    }

    public static int removeDuplicates(int[] nums) {
        int index  = 1, curNum = 1;
        for (int i = 1; i < nums.length; ++i){
           if (nums[i] == nums[i-1]){
               if (curNum < 2){
                   ++curNum;
                   nums[index++] = nums[i];
               }
          }else{
               curNum = 1;
               nums[index++] = nums[i];
            }
         }
        
        return index;
    }
}