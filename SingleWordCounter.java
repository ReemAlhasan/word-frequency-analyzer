package textproc;

//Denna klass är till för att räkna hur många gånger ett givet ord förekommer.
public class SingleWordCounter implements TextProcessor {
	private String word;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}

	public void process(String w) {
		if (w.equals(word)) {
			n++;
		}
	}

	public void report() {
		System.out.println(word + ": " + n);
	}

}
