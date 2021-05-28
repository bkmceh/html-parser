import org.junit.Test;


public class HtmlDownloaderTest {

    HtmlDownloader htmlDownloader;

    @Test
    public void downloadWhenURLisFull() {
        String URL = "https://www.simbirsoft.com/";
        htmlDownloader = new HtmlDownloader(URL);
        htmlDownloader.download();
    }

    @Test
    public void downloadWhenURLisFull2() {
        String URL = "https://www.simbirsoft.com";
        htmlDownloader = new HtmlDownloader(URL);
        htmlDownloader.download();
    }

    @Test(expected = RuntimeException.class)
    public void downloadWhenURLisValidButNotFull() {
        String URL = "www.simbirsoft.com/";
        htmlDownloader = new HtmlDownloader(URL);
        htmlDownloader.download();
    }

    @Test(expected = RuntimeException.class)
    public void downloadWhenURLisNotValid() {
        String URL = "hts://ww.simbirft.co";
        htmlDownloader = new HtmlDownloader(URL);
        htmlDownloader.download();
    }

    @Test(expected = RuntimeException.class)
    public void downloadWhenURLisValidButCannotDownload() {
        String URL = "https://ranobelib.me/mushoku-tensei/v29/c6";
        htmlDownloader = new HtmlDownloader(URL);
        htmlDownloader.download();
    }


}