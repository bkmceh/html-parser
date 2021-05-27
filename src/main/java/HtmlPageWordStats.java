import java.util.HashMap;

public class HtmlPageWordStats {

    private final HashMap<String, Integer> words;

    public HtmlPageWordStats(HashMap<String, Integer> words) {
        this.words = words;
    }

    public void printResult() {
        for (String key :
                words.keySet()) {
            System.out.printf("%s: %s%n", key, words.get(key));
        }
    }
}
