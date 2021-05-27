import java.util.HashMap;

public class WordStats {

    private final HtmlPageBody body;

    public WordStats(HtmlPageBody body) {
        this.body = body;
    }

    public HtmlPageWordStats count(char[] delimiters) {

        HashMap<String, Integer> words = new HashMap<>();

        String text = body.getText();

        char[] chars = text.toCharArray();

        int indexBegin = 0;

        for (int i = 0; i < chars.length; i++) {
            for (char delimiter :
                    delimiters) {
                if (delimiter == chars[i]) {
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
