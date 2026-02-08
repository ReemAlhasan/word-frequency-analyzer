package textproc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor{
    private String[] words;
    private Map<String, Integer> m = new HashMap<>();
    //private Map<String, Integer> m = new TreeMap<>();

    public MultiWordCounter(String[] words) {
        this.words = words;
        for (String word : words) {
            m.put(word.toLowerCase(), 0);
        }
    }

    public void process(String w) {
        w = w.toLowerCase();
		if (m.containsKey(w)) {
            m.put(w, m.get(w) + 1);
        }
	}

	public void report() {
		for (String key : m.keySet()) {
            System.out.println(key + " " + m.get(key));
        }
	}
}
