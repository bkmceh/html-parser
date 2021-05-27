import org.jsoup.Jsoup;

import java.io.IOException;

public class HtmlDownloader {

    private final String URL;

    public HtmlDownloader(String url) {
        URL = url;
    }

    public HtmlPageBody download() {
        String result = null;
        try {
            result = Jsoup.parse(Jsoup.connect(URL).get().html()).body().text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HtmlPageBody(result);
    }
}
