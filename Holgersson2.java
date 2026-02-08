package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson2 {

    public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
            "halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
            "södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
            "öland", "östergötland" };

    public static void main(String[] args) throws FileNotFoundException {
        long t0 = System.nanoTime();

        // Landskap
        Scanner source1 = new Scanner(new File("C:/Users/dhuha/Documents/java/edaa01-workspace-vscode/lab2-3/nilsholg.txt"));
        Set<String> stopwords = loadStopwords("C:/Users/dhuha/Documents/java/edaa01-workspace-vscode/lab2-3/undantagsord.txt");
        TextProcessor regions1 = new GeneralWordCounter(stopwords);

        while (source1.hasNext()) {
            String word = source1.next().toLowerCase();
            regions1.process(word);
        }

        source1.close();
        regions1.report();

        long t1 = System.nanoTime();
        System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
    }

    public static Set<String> loadStopwords(String filepath) throws FileNotFoundException {
        Set<String> stopwords = new HashSet<>();
        Scanner source = new Scanner(new File(filepath));

        while (source.hasNext()) {
            String stopword = source.next().toLowerCase();
            stopwords.add(stopword);
        }

        source.close();
        return stopwords;
    }
}
