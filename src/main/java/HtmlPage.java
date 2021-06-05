import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/**
 * Store html string with text and have getBody method to get body
 */
public class HtmlPage {

    private final String html;

    public HtmlPage(String html) {
        this.html = html;
    }

    public Element getBody() {
        return Jsoup.parse(html).body();
    }
}
