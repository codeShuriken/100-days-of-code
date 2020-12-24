import java.util.Map;
import java.util.HashMap;

class MinimumWindowSubString{
    public static void main(String[] args) {
        String s = "ADOBECODEBANC" , t = "ABC";
        System.out.println("Expected: BANC, got " + minWindow(s, t));

        String s1 = "a", t1 = "a";
        System.out.println("Expected: a, got " + minWindow(s1, t1));

    }

    public static String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        int start = 0, end  = 0, count  = 0, minStart = -1, minLen = Integer.MAX_VALUE;
        while (end < s.length()){
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0)-1);
                if (map.get(ch) >= 0)
                    count++;
            }
            while (count == t.length()){
                if (minLen > end-start+1){
                    minLen  = end -start + 1;
                    minStart = start;
                }
                char ch1 = s.charAt(start);
                if (map.containsKey(ch1)){
                    map.put(ch1, map.getOrDefault(ch1, 0)+1);
                    if (map.get(ch1) > 0)
                     --count;
                }
                ++start;
            }
            ++end;
        }
         return minStart == -1 ? "" : s.substring(minStart, minStart + minLen);
    }
}