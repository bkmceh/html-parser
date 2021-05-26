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
        boolean isFind = true;

        Iterator<Character> iterator = delimeters.iterator();

        int indexBegin = 0;
        int indexEnd = 0;

        while (iterator.hasNext()) {
            String delimiter = iterator.next().toString();
            if (words.contains(delimiter)) {
                System.out.println(words.indexOf(delimiter));
                indexEnd = words.indexOf(delimiter);
                System.out.format("\nDelimiter: %s, %s\n", delimiter, words.substring(indexBegin, indexEnd));
                indexBegin = indexEnd;
            }
        }

//        while (isFind) {
//            for (Object element :
//                    delimeters) {
//                String elementChar = (String) element;
//                if (words.contains(elementChar)) {
//                    System.out.format("\n%s", words.substring(words.indexOf(elementChar)));
//                }
//            }
//            isFind = false;
//        }
    }
}

