class CanBePalindrome{
    public static void main(String[] args) {
      String s  = "carrace";
      System.out.println(canBePalindrome(s));
    }
  
  
    private static boolean canBePalindrome(String s){
      int[] char_map = new int[26];
      for (char c : s.toCharArray())
        char_map[c - 'a']++;
      
      int odd_count = 0;
      for (int i = 0; i < char_map.length; i++){
        if (char_map[i] % 2 != 0)
          odd_count++;
        if (odd_count > 1)return false;
      }
  
      return true;
    }
  }