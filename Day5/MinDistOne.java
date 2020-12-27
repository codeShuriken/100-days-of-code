class MinDistOne{
    public static void main(String[] args) {
        String a = "abcd", b = "bbcd";
        System.out.println(isEditDistanceOne(a, b));
        String a1 = "abc", b1 = "bc";
        System.out.println(isEditDistanceOne(a1, b1));
        String a2  = "aaaa", b2 = "aaaaaa";
        System.out.println(isEditDistanceOne(a2, b2)); 
    }

    public static boolean isEditDistanceOne(String s1, String s2){
        int m = s1.length(), n = s2.length();
        if (Math.abs(m-n) > 1)return false;
        int count = 0;
        int i = 0, j = 0;
        while (i < m && j < n){
            if (s1.charAt(i) != s2.charAt(j)){
                if (m > n)i++;
                else if (n > m)j++;
                else{
                    i++;
                    j++;
                }
                ++count;
                if (count > 1)return false;
            }else{
                ++i;
                ++j;
            }
        }

        if (i < m || j < n)++count;

        return count == 1;
    }
}