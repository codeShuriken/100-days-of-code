import java.util.Arrays;
import java.util.Random;

class RandomGeneration{
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        int k = 5;
        System.out.println(Arrays.toString(generateKNumbers(nums, k)));
    }
    
    //Reservoir Sampling
    public static int[] generateKNumbers(int[] nums, int k){
        int n = nums.length;
        Random rand = new Random();
        int[] res = new int[k];
        int i = 0;
        for (;i < k;++i){
            res[i] = nums[i];
        }

        for (; i < n; ++i){
            int j = rand.nextInt(i+1);
            if (j < k){
                res[j] = nums[i];
            }
        }

        return res;
    }
}
