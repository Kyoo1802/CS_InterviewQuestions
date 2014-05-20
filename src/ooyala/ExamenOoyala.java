package ooyala;


import java.util.Arrays;

public class ExamenOoyala {
    public static boolean areAnagrams(String w1, String w2){
        if(w1.length()!=w2.length())
            return false;
        char[] arW1=w1.toCharArray();
        char[] arW2=w2.toCharArray();
        Arrays.sort(arW1);
        Arrays.sort(arW2);
        return String.valueOf(arW1).compareTo(String.valueOf(arW2))==0;
    }
    public static void check_anagrams(String[] firstWords, String[] secondWords) {
        for (int i = 0; i < firstWords.length; i++) 
            System.out.println(areAnagrams(firstWords[i],secondWords[i])?1:0);
        
    }
    public static void main(String[] args) {
        check_anagrams(new String[]{"cinema", "host", "aba", "train"}, 
                new String[]{ "iceman", "shot", "bab", "rain"});
    }
}
