import java.util.*;

class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));

        int[][] intervals1 = {{1,4},{2,6},{6,10},{9,18}};
        System.out.println(Arrays.deepToString(merge(intervals1)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; ++i){
            if (intervals[i][0] <= cur[1]){
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }else{
                res.add(cur);
                cur = intervals[i];
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][2]);
    }
}