package interviewquestions;

import java.util.LinkedList;

public class Parenthesis {
    public static void check_braces(String[] expressions) {
        for (String expression : expressions) {
            System.out.println(solve(expression)?"1":0);
        }
    }
    public static void main(String[] args) {
        check_braces(new String[]{")(){}", "[]({})", "([])", "{()[]}", "([)]"});
    }

    private static boolean solve(String s) {
        LinkedList<Character> p= new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(isOpen(c))
                p.add(c);
            else if(isClose(c)){
                if(p.isEmpty() || !isPair(c,p.getLast(),true))
                    return false;
                p.removeLast();
            }
                
        }
        return p.isEmpty();
    }
    private static boolean isPair(char c1, char c2, boolean f){
        if(c1=='(' && c2==')')
            return true;
        if(c1=='{' && c2=='}')
            return true;
        if(c1=='[' && c2==']')
            return true;
        return f==true && isPair(c2, c1,false);
    }
    private static boolean isOpen(char c) {
        return c=='('|| c=='{'||c=='[';
    }
    private static boolean isClose(char c) {
        return c==')'|| c=='}'||c==']';
    }
}
