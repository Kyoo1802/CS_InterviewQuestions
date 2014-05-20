package interviewquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class GroupAnagrams {
    //Trie
    public static void main(String[] args) {
        solve();
    }
    public static void solve() {
        Trie trie = new Trie();
        String[] strWords = {"carthorse", "horse", "horse cart", "i do not know u", "ok i now donut", "orchestra"};
        for (String strWord : strWords) 
            trie.add(getSortStr(strWord), strWord);
        trie.printNodesFinals();
    }
    
    private static String getSortStr(String s) {
        char[] arS = s.replaceAll("[\\W\\d]", "").toCharArray();
        Arrays.sort(arS);//COUNTING SORT
        return String.valueOf(arS);
    }

    static class Trie {
        Node n = new Node('$');
        Set<Node> nodesFinals = new LinkedHashSet<>();

        public void printNodesFinals() {
            for (Node nodo : nodesFinals) 
                System.out.println(nodo.getListStr());
        }

        public Set<Node> getNodes() {
            return nodesFinals;
        }

        public void add(String w1, String w2) {
            add(n, w1, 0, w2);
        }

        private void add(Node n, String w1, int idx, String w2) {
            if (idx >= w1.length()) {
                n.addWord(w2);
                nodesFinals.add(n);
                return;
            }
            char car = w1.charAt(idx);
            Node next;
            if (!n.cars.containsKey((int) car)) 
                n.cars.put((int) car, (next = new Node(car)));
            else 
                next = n.cars.get((int) car);
            
            add(next, w1, idx + 1, w2);
        }

    }

    static class Node {

        HashMap<Integer, Node> cars = new HashMap<>();
        char c;
        List<String> listWords;

        public Node(char c) {
            this.c = c;
        }

        public void addWord(String s) {
            if (listWords == null) {
                listWords = new LinkedList<>();
            }
            listWords.add(s);
        }

        public String getListStr() {
            return listWords.toString();
        }
    }
}