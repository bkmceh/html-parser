import java.util.Map;
import java.util.HashMap;
import org.jsoup.nodes.Element;


public class WordsCounter {

    private final Element body;

    public WordsCounter(Element body) {
        this.body = body;
    }

    /**
     * Count words and them amount at page
     * @param delimiters template to find different words
     * @return HtmlPageWordStats with stats of words
     */
    public HtmlPageWordStats count(char[] delimiters) {

        Map<String, Integer> words = new HashMap<>();

        String text = body.text();

        char[] textChar = text.toCharArray();

        int indexBegin = 0;

        for (int i = 0; i < textChar.length; i++) {
            for (char delimiter :
                    delimiters) {
                if (delimiter == textChar[i]) {
                    String word = text.substring(indexBegin, i).toUpperCase();
                    indexBegin = i + 1;
                    if (word.length() == 0) continue;

                    if (!words.containsKey(word)) {
                        words.put(word, 1);
                    } else {
                        words.put(word, words.get(word) + 1);
                    }
                }
            }
        }
        return new HtmlPageWordStats(words);
    }
}
