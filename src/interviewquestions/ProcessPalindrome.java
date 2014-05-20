package interviewquestions;

public class ProcessPalindrome {
    public static String resolver(String w){        
        int[] v= new int[256];
        for(int i=0;i<w.length();i++)
            ++v[w.charAt(i)];
        
        int posImpar=-1;
        for (int i = 0; i < v.length; i++){
            if(v[i]%2!=0){
                if(posImpar!=-1)
                    return "-1";
                posImpar=i;
            }
        }        
        char[] res=new char[w.length()];
        int c=0;
        for (int i = 0; i < v.length; i++) {
            if(v[i]>0){
                while(v[i]>1){
                    res[c]=(char)i;
                    res[res.length-c-1]=(char)i;
                    v[i]-=2;
                    c++;
                }
            }
        }
        if(posImpar!=-1)
            res[res.length/2]=(char)posImpar;
        return String.valueOf(res);
        
    }
    public static void compute_palindromes(String[] words) {
        for (String w : words) {
            System.out.println(resolver(w));
        }
        
    }
    public static void main(String[] args) {
        compute_palindromes(new String[]{"ivcci", "oyotta", "cecarar", "bbb", "babbb"});
    }
}
