class DistinctSubsequences{
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));

    }

    public static int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)return 0;
       if (s.length() < t.length())return 0;
       
       int m = s.length(), n = t.length();
       int[][] dp = new int[m+1][n+1];

       for (int i = 0; i < dp.length; ++i){
           for (int j = 0; j < dp[0].length; ++j){
               if (j == 0)dp[i][j] = 1;
               else if (i > 0){
                    if (s.charAt(i-1) == t.charAt(j-1)){
                       dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    }else{
                       dp[i][j] = dp[i-1][j];
                    }
               }
           }
       }

       
       return dp[m][n];
   }
}