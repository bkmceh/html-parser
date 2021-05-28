import java.io.File;
import org.jsoup.Jsoup;
import java.io.FileWriter;
import java.io.IOException;


public class HtmlDownloader {

    private final String URL;

    private final String htmlPagePath = "./htmlPage/page.html";

    public HtmlDownloader(String url) {
        URL = url;
    }

    public HtmlPageBody download() {
        try {
            final String body = Jsoup.parse(Jsoup.connect(URL).get().html()).body().text();
            save(Jsoup.connect(URL).get().html());
            return new HtmlPageBody(body);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Unable to parse html body text because of %s", e.getMessage()), e);
        }
    }

    private void save(final String html) {
        try {
            File file = new File(htmlPagePath);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(html);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(String.format("Unable to save html page because of %s", e.getMessage()), e);
        }
    }
}
