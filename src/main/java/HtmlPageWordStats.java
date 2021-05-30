import java.util.Map;

public class HtmlPageWordStats {

    private final Map<String, Integer> wordStatsCounter;

    public HtmlPageWordStats(Map<String, Integer> wordStatsCounter) {
        this.wordStatsCounter = wordStatsCounter;
    }

    public void printResult() {
        wordStatsCounter.forEach((key, value) -> System.out.printf("%s: %s%n", key, value));
    }
}
