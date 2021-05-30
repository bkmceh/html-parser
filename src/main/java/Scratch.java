import org.jsoup.Jsoup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Scratch {
    private static final String HTML_PAGE_PATH = "./htmlPage/page.html";

    private final String URL;

    public Scratch(String url) {
        URL = url;
    }

    public HtmlPage download() {
        try {
            final String html  = Jsoup.connect(URL).get().html();
            this.save(html);
            return new HtmlPage(html);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Unable to download and save html because of %s", e.getMessage()), e);
        }
    }

    private void save(final String html) {
        try {
            Files.writeString(Paths.get(HTML_PAGE_PATH), html, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING );
        } catch (IOException e) {
            throw new RuntimeException(String.format("Unable to save html page because of %s", e.getMessage()), e);
        }
    }
}