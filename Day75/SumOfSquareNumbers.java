import java.util.HashSet;
import java.util.Set;

class SumOfSquareNumbers {

    public static void main(String[] args) {
        int c = 8;
        System.out.println(judgeSquareSumSet(c));
        System.out.println(judgeSquareSumTwoPointers(c));
    }

    public static boolean judgeSquareSumTwoPointers(int c) {
        int low  = 0, high = (int)Math.sqrt(c);
        
        while (low <= high){
            int x = low*low + high*high;
            if (x == c)return true;
            else if (x < c)low++;
            else high--;
        }
        return false;
    }
    
    public static boolean judgeSquareSumSet(int c) {
       Set<Integer> set = new HashSet<>();
       for (int i = 0; i <= Math.sqrt(c); ++i){
            int x = i * i;
            set.add(x);
            if (set.contains(c - x))return true;
       }
        return false;
    }
    
    
}