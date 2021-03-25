import java.util.LinkedList;
import java.util.List;

class pathInZigzagBT {

    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(14));

        System.out.println(pathInZigZagTree(26));

    }

    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new LinkedList<>();
        res.add(label);
        while (label != 1){
            int d = (int)(Math.log(label)/Math.log(2));
            int offset = (int)Math.pow(2, d+1) - 1 - label;
            label = (int)(Math.pow(2,d) + offset)/2;
            res.add(0,label);
        }
        return res;
        
    }
}