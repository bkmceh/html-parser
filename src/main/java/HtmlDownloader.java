import org.jsoup.Jsoup;

public class HtmlDownloader {

    private final String URL;

    public HtmlDownloader(String url) {
        URL = url;
    }

    public HtmlPageBody download() {
        try {
            final String body = Jsoup.parse(Jsoup.connect(URL).get().html()).body().text();
            return new HtmlPageBody(body);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Unable to parse html body text because of %s", e.getMessage()), e);
        }
    }
}
