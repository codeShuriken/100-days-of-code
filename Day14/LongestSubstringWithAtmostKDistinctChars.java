import java.util.Map;
import java.util.HashMap;

class LongestSubstringWithAtmostKDistinctChars{
    public static void main(String[] args) {
        String s = "eceba";
        int k = 3;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int maxLen = 0;
        
        while (end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0)+ 1);
            while (map.size() > k){
                char ch = s.charAt(start);
                if (map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.getOrDefault(ch, 0)-1);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        
        return maxLen;
        
    }
}