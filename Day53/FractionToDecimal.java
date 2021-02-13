import java.util.Map;
import java.util.HashMap;

class FractionToDecimal {
    public static void main(String[] args) {
        int a  = -1;
        int b = -2147483648;
        System.out.println(fractionToDecimal(a, b));
        assert fractionToDecimal(a, b).equals("0.0000000004656612873077392578125");

        assert fractionToDecimal(4, 333).equals("0.(012)");
        assert fractionToDecimal(1, 20).equals("0.05");
        assert fractionToDecimal(10, 3).equals("3.(3)");

    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)return "0";
        StringBuilder sb = new StringBuilder();
        sb.append((numerator < 0 ^ denominator < 0) ? "-" : "");
        long numr = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        //System.out.println("Numerator: " +  numr + " Denominator: " + den);

        
        sb.append(numr / den);
        long num = numr % den;
        if (num == 0)return sb.toString();
        
        sb.append('.');
        
        Map<Long, Integer> map = new HashMap<>();
        while (num > 0){
            map.put(num, sb.length());
            
            num *= 10;
            sb.append(num / den);
           // System.out.println("Numerator: " +  num + " Denominator: " + den);
            num = num % den;
            
            Integer getKey = map.get(num);
            if (getKey != null){
                sb.insert(getKey, "(");
                sb.append(')');
                break;
            }
            
        }
        return sb.toString();
    }
}