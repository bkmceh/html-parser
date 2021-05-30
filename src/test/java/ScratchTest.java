import org.junit.Test;

import static org.junit.Assert.*;

public class ScratchTest {

    @Test
    public void downloadWhenURLisFull() {
        String URL = "https://www.simbirsoft.com/";
        new Scratch(URL).download();
    }

    @Test
    public void downloadWhenURLisFull2() {
        String URL = "https://www.simbirsoft.com";
        new Scratch(URL).download();
    }

    @Test(expected = RuntimeException.class)
    public void downloadWhenURLisValidButNotFull() {
        String URL = "www.simbirsoft.com/";
        new Scratch(URL).download();
    }

    @Test(expected = RuntimeException.class)
    public void downloadWhenURLisNotValid() {
        String URL = "hts://ww.simbirft.co";
        new Scratch(URL).download();
    }

    @Test(expected = RuntimeException.class)
    public void downloadWhenURLisValidButCannotDownload() {
        String URL = "https://ranobelib.me/mushoku-tensei/v29/c6";
        new Scratch(URL).download();
    }


}