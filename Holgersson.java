package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		//landskap
		Scanner source1 = new Scanner(new File("C:/Users/dhuha/Documents/java/edaa01-workspace-vscode/lab2-3/nilsholg.txt"));
		//TextProcessor regions1 = new MultiWordCounter(REGIONS);
		/*List<TextProcessor> list = new ArrayList<TextProcessor>();
		TextProcessor p1 = new SingleWordCounter("nils");
		TextProcessor p2 = new SingleWordCounter("norge");
		list.add(p1);
		list.add(p2);*/

		source1.findWithinHorizon("\uFEFF", 1);
		source1.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); 

		/*while (source1.hasNext()) {
			String word = source1.next().toLowerCase();
    		regions1.process(word);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).process(word);
			}
		}*/

		/*source1.close();
		regions1.report();*/
		
		/*for (int i = 0; i < list.size(); i++) {
			list.get(i).report();
		}*/
		

		//alla ord
		Set<String> stopwords = new HashSet<>();
		Scanner source2 = new Scanner(new File("C:/Users/dhuha/Documents/java/edaa01-workspace-vscode/lab2-3/undantagsord.txt"));
		TextProcessor regions2 = new GeneralWordCounter(stopwords);

		while (source2.hasNext()) {
			String stopword = source2.next().toLowerCase();
			stopwords.add(stopword);
		}

		source2.close();

        while (source1.hasNext()) {
            String word = source1.next().toLowerCase();
            regions2.process(word);
        }

        source1.close();
        regions2.report();
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
	}
}