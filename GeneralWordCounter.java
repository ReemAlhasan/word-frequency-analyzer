package textproc;

import java.util.*;

public class GeneralWordCounter implements TextProcessor{
    private Set<String> stopwords;
    private Map<String, Integer> m = new HashMap<>();
    //private Map<String, Integer> m = new TreeMap<>();
    private List<Map.Entry<String, Integer>> wordList = new ArrayList<>();

    public GeneralWordCounter(Set<String> stopwords ) {
        this.stopwords = stopwords;
    }

    public void process(String w) {
		if (!stopwords.contains(w)) {
            w = w.toLowerCase();
            m.put(w, m.getOrDefault(w, 0) + 1);
        }
	}

	public void report() {
		/*for (String key : m.keySet()) {
            if (m.get(key) >= 200) {
                System.out.println(key + " " + m.get(key));
            }
        }*/
        wordList = new ArrayList<>(m.entrySet());
        //wordList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        //wordList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        //wordList.sort(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()).reversed());
        wordList.sort(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()));
        
        int topCount = Math.min(5, wordList.size());

        for (int i = 0; i < topCount; i++) {
            Map.Entry<String, Integer> entry = wordList.get(i);
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
	}

    public List<Map.Entry<String, Integer>> getWordList() {
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(m.entrySet());
        return wordList;
    }
}
