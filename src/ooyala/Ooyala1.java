package ooyala;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Ooyala1 {
    public static void main(String[] args) throws IOException{
        BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
        String tests[]={"This (is <a> {well [formatted]}) string","This (is <a {bad> [formatted)}) (string"};
        for (String test : tests) {
            System.out.println(isValid(test));
        }
    }
    private static boolean isValid(String t){
        LinkedList<Character> list= new LinkedList<>();
        for (int i = 0; i < t.length(); i++) {
            char car=t.charAt(i);
            if(isOpen(car)){
               list.push(car);
            }
            else if(isClose(car)){
                if(list.isEmpty())
                    return false;
                else{
                    char firstC=list.removeFirst();
                    if(!pair(firstC,car))
                        return false;
                }
            }
        }
        return list.isEmpty();
    }

    private static boolean isOpen(char c) {
        char[] open={'(','[','<','{'};
        for (int i = 0; i < open.length; i++) {
            if(open[i]==c)
                return true;
        }
        return false;
    }
    private static boolean isClose(char c) {
        char[] close={')',']','>','}'};
        for (int i = 0; i < close.length; i++) {
            if(close[i]==c)
                return true;
        }
        return false;
    }

    private static boolean pair(char open, char close) {
        return (open=='(' && close==')') || (open=='[' && close==']') || 
                (open=='{' && close=='}') || (open=='<' && close=='>');
    }
}
