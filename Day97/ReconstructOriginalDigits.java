class ReconstructOriginalDigits{
    public static void main(String[] args) {
        String s = "owoztneoer";
        System.out.println(originalDigits(s));
        s = "fviefuro";
        System.out.println(originalDigits(s));
    }

    public static String originalDigits(String s) {
        int[] counts = new int[10];
        
        for (char c : s.toCharArray()){
            if (c == 'z')counts[0]++;
            if (c == 'w')counts[2]++;
            if (c == 'g')counts[8]++;
            if (c == 'x')counts[6]++;
            if (c == 'u')counts[4]++;
            if (c == 's')counts[7]++; //6,7
            if (c == 'h')counts[3]++; //3,8
            if (c == 'f')counts[5]++; //5,4
            if (c == 'i')counts[9]++; //5,6,8,9
            if (c == 'o')counts[1]++; //0,1,2,4
            
        }
        
        counts[7] -= counts[6];
        counts[3] -= counts[8];
        counts[5] -= counts[4];
        counts[9] -= (counts[5] + counts[6] + counts[8]); 
        counts[1] -= (counts[4] + counts[0] + counts[2]);
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; ++i){
            for (int j = 0; j < counts[i]; ++j){
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}