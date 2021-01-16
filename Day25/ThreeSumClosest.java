import java.util.Arrays;
class ThreeSumClosest {
    public static void main(String[] args) {
        int[] A = {-1,2,1,-4};
        int target  = 1;
        System.out.println("The closest 3 sum target to " + target + " is : " + threeSumClosest(A, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[nums.length - 1];;
        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length - 3; ++i){
            int a = nums[i];
            if (i == 0 || (nums[i] != nums[i-1])){
                int start = i+1, end = nums.length - 1;
                while (start < end){
                     int sum = a + nums[start] + nums[end];
                    if (sum < target){
                        while (start < end && nums[start] == nums[start+1])start++;
                        start++;
                    }else if (sum > target){
                        while (start < end && nums[end] == nums[end-1])end--;
                        end--;
                    }else{
                        return sum;
                    }
                    if (Math.abs(sum - target) < Math.abs(closest - target))closest = sum;
                }
                
            }
        }
        
        return closest;
    }
}