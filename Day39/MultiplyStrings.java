public class MultiplyStrings {
    public static void main(String[] args) {
        String a = "3", b = "2";
        assert multiply(a, b).equals("6");
        
        String c = "123", d ="45678";
        assert multiply(c, d).equals("5618394");

        String e = "0", f = "999";
        assert multiply(e, f).equals("0") : "Not Zero!";
    }


    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))return "0";
        int m  = num1.length(), n = num2.length();
        int[] res = new int[m+n];
        for (int i  = m-1; i >= 0; --i){
            for (int j  = n-1; j >= 0; --j){
                int p1  = i + j, p2 = i + j + 1;
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                prod += res[p2];
                res[p2] = (prod)%10;
                res[p1] += prod/10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int r : res){
            if (!(sb.length() == 0 &&  r == 0))sb.append(r);
        }
        return sb.toString();
    }
}
