import java.util.List;
import java.util.ArrayList;


class RestoreIPAddress {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));

        String t = "010010";
        System.out.println(restoreIpAddresses(t));

        String u = "0000";
        System.out.println(restoreIpAddresses(u));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s, 0, new StringBuilder(), 0);
        
        return res;
    }
    
    private static void dfs(List<String> res, String s, int start, StringBuilder sb, int dots){
        if (start == s.length() && dots == 4){
            res.add(sb.toString());
            return;
        }
        
        if (dots > 4)return;
        
        int len = sb.length();
        int cur = 0;
        for (int i = start; i < s.length(); ++i){
            cur = cur * 10  + (s.charAt(i) - '0');
            if (cur >= 0 && cur <= 255){
                sb.append(cur);
                if (dots < 3)
                    sb.append('.');
                dfs(res, s, i+1, sb, dots+1);
                sb.setLength(len);
            }
            if (cur == 0)break;
        }
    }
}