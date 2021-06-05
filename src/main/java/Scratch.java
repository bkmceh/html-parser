import org.jsoup.Jsoup;
import org.slf4j.Logger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import org.slf4j.LoggerFactory;
import java.nio.file.StandardOpenOption;


public class Scratch {

    private final Logger log = LoggerFactory.getLogger(Scratch.class);

    private static final String HTML_PAGE_PATH = "./htmlPage/page.html";

    private final String URL;

    public Scratch(String url) {
        URL = url;
    }


    /**
     * Download html page by URL and save it
     * @return HtmlPage with html
     */
    public HtmlPage download() {
        try {
            final String html  = Jsoup.connect(URL).get().html();
            this.save(html);
            return new HtmlPage(html);
        } catch (IOException e) {
            final String error = String.format("Unable to download and save html because of %s", e.getMessage());
            log.error(error);
            throw new RuntimeException(error, e);
        }
    }

    /**
     * Save html page into htmlPage directory
     * @param html string with data
     */
    private void save(final String html) {
        try {
            final Path path = Paths.get(HTML_PAGE_PATH);
            Files.createDirectories(path.getParent());
            Files.writeString(path, html, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            final String error = String.format("Unable to save html page because of %s", e.getMessage());
            log.error(error);
            throw new RuntimeException(error, e);
        }
    }

}