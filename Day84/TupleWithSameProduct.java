import java.util.Map;
import java.util.HashMap;

class TupleWithSameProduct {
    public static void main(String[] args) {
        int[] nums = {2,3,4,6,8,12};    
        System.out.println(tupleSameProduct(nums));
        int[] nums1 = {2,3,5,7};
        System.out.println(tupleSameProduct(nums1));
    }

    public static  int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int i = 0; i < nums.length; ++i){
            for (int j = i+1; j < nums.length; ++j){
                int key = nums[i] * nums[j];
                
                total += (8 * map.getOrDefault(key, 0));
                
                map.put(key, map.getOrDefault(key, 0)+1);
            }
        }
        
       
        return total;
    }
}