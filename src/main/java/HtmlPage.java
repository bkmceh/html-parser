import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class HtmlPage {

    private final String html;

    public HtmlPage(String html) {
        this.html = html;
    }

    public Element getBody() {
        return Jsoup.parse(html).body();
    }
}
