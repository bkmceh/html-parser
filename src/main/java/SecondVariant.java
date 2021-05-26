import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//import javax.swing.text.Document;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class SecondVariant {
    public static void main(String[] args) throws IOException {
        DelimiterList delimiterList = new DelimiterList(new Character[]{' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')'});

        String html = Jsoup.connect(InputURL.url).get().html();
        Document htmlDoc = Jsoup.parse(html);
        String words = htmlDoc.body().text();

        System.out.println(htmlDoc.body().text());
        System.out.println(delimiterList.delimiters);
        findWords(words, delimiterList.delimiters);
    }


    private static void findWords(String words, HashSet delimeters) {

        char[] chars = words.toCharArray();

        int indexBegin = 0;


        for (int i = 0; i < chars.length; i++) {
            if (delimeters.contains(chars[i])) {
                String word = words.substring(indexBegin, i);
                System.out.println(word);
                indexBegin = i + 1;
            }
        }

    }
}

