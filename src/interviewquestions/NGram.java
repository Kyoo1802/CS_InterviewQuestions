package interviewquestions;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class NGram {

    public static void find_ngram(String text, Integer ngramLength) {
        TreeMap<String, Integer> vals = new TreeMap<String, Integer>();
        String s=text.replace(" ", "_");
        s+="$";
        SuffixArray sArr = new SuffixArray(s );
        for (int i = 1; i < sArr.lcp.length; i++) {
            int idx = sArr.idxSfxSorted[i];
            if(idx+ngramLength>s.length())continue;
            String ngram = s.substring(idx, idx + ngramLength);
            if(ngram.contains("_")) continue;
            if (vals.containsKey(ngram)) {
                vals.put(ngram, vals.get(ngram) + 1);
            } else {
                vals.put(ngram, 1);
            }
        }
        //System.out.println(vals);
        TreeSet<String> resp= new TreeSet<String>();
        int max=0;
        for (Map.Entry<String,Integer> entry : vals.entrySet()) {
            max=Math.max(max, entry.getValue());
        }
        for (Map.Entry<String,Integer> entry : vals.entrySet()) {
            if(entry.getValue()==max)
                resp.add(entry.getKey());
        }
        System.out.println(resp.first());

    }

    public static void main(String[] args) {
        String s = "aaaab a0a baaab c";
        find_ngram(s, 3);
    }
    static class SuffixArray implements Comparator<Integer> {

        private String s;
        private Integer[] idxSfxSorted, rankIdx, lcp;
        private int t;

        public SuffixArray(String s) {
            this.s = s;
            rankIdx = new Integer[s.length() * 2 + 2];
            idxSfxSorted = new Integer[s.length()];
            lcp = new Integer[s.length()];
            Arrays.fill(rankIdx, 0);
            Arrays.fill(lcp, 0);
            suffixArray();
            lcp();
        }

        public void fixRank(int rIdxI, int rIdxJ) {
            int rankINextT = rankIdx[idxSfxSorted[rIdxI] + t];
            int tamGroup = rIdxJ - rIdxI;
            int d = 0;
            int np = rIdxI;
            int pk;
            for (int i = 0; i < tamGroup; i++) {
                if (((pk = rankIdx[idxSfxSorted[rIdxI] + t]) != rankINextT) && !(np <= rankINextT && pk < np + tamGroup)) {
                    rankINextT = pk;
                    d = i;
                }
                rankIdx[idxSfxSorted[rIdxI++]] = np + d;
            }
        }

        @Override
        public int compare(Integer i, Integer j) {
            return rankIdx[i + t] - rankIdx[j + t];
        }

        private void suffixArray() {
            int[] abc = new int[256];
            //---Counting sort Inicia
            for (int i = 0; i < s.length(); i++) {
                abc[s.charAt(i)]++;//se tiene la frecuencia
            }
            for (int i = 1; i < abc.length; i++) {
                abc[i] += abc[i - 1];//se realiza la frecuencia acumulada
            }
            for (int i = 0; i < s.length(); i++) {
                idxSfxSorted[--abc[s.charAt(i)]] = i;//se consigue el ordenamiento de caracteres
            }        //---Counting sort Completo
            for (int i = s.length() - 1; i >= 0; i--) {
                rankIdx[i] = abc[s.charAt(i)];//caracteres indice ordenado(repetidos mismo valor)
            }
            for (t = 1; t < s.length(); t *= 2) {//potencias de 2
                for (int i = 0, j = 1; i < s.length(); i = j++) {
                    //agrupar prefijos con el mismo nivel (necesario ordenar en base al segundo caracter)
                    while (j < s.length() && rankIdx[idxSfxSorted[i]] == rankIdx[idxSfxSorted[j]]) {
                        ++j;
                    }
                    if (j - i > 1) {//si el grupo es mayor a 1
                        Arrays.sort(idxSfxSorted, i, j, this);//ordena el rango i-j en base al siguiente T caracter
                        fixRank(i, j);
                    }
                }
            }
        }

        private void lcp() {
            int tam = 0, i, j;
            for (i = 0; i < s.length(); i++) {
                if (rankIdx[i] > 0) {
                    j = idxSfxSorted[rankIdx[i] - 1];
                    while (j + tam < s.length() && s.charAt(i + tam) == s.charAt(j + tam)) {
                        tam++;
                    }
                    lcp[rankIdx[i] - 1] = tam;
                    if (tam > 0) {
                        tam--;
                    }
                }
            }
            lcp[s.length() - 1] = 0;
        }

    }
}
