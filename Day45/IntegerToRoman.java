class IntegerToRoman {
    public static void main(String[] args) {
        int a = 9;
        System.out.println(intToRoman(a));
        int b = 1994;
        System.out.println(intToRoman(b));
    }

    public static String intToRoman(int num) {
        String[] numerals = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        if (num > 3999 || num < 1){
            throw new IllegalArgumentException("Number incorrect!");
        }
        StringBuilder sb = new StringBuilder();
        int  i = 0;
        while (num > 0){
            if (num - values[i] >= 0){
                sb.append(numerals[i]);
                num -= values[i];
            }else{
                ++i;
            }
        }
        return sb.toString();
    }
}