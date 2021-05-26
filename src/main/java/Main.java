import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) throws IOException {
        DelimiterList delimiterList =
                new DelimiterList(new Character[]{
                        ' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')'});//TODO for example \n or \t

        String html = Jsoup.connect(InputURL.url).get().html();
        Document htmlDoc = Jsoup.parse(html);
        String words = htmlDoc.body().text();

        findWords(words, delimiterList.delimiters);
        printResult();
    }

    private static void findWords(String words, HashSet<Character> delimeters) {

        char[] chars = words.toCharArray();

        int indexBegin = 0;

        for (int i = 0; i < chars.length; i++) {
            if (delimeters.contains(chars[i])) {
                String word = words.substring(indexBegin, i);
                indexBegin = i + 1;
                if (word.length() == 0) continue;
                if (!WordDictionary.wordDictionary.containsKey(word)) {
                    WordDictionary.wordDictionary.put(word, 1);
                } else {
                    WordDictionary.wordDictionary.put(word, WordDictionary.wordDictionary.get(word) + 1);
                }
            }
        }

    }

    private static void printResult() {
        for (String key :
                WordDictionary.wordDictionary.keySet()) {
            System.out.printf("%s: %s%n", key, WordDictionary.wordDictionary.get(key));
        }
    }
}

