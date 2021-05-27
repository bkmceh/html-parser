public class Main {

    private final static String URL = "https://www.simbirsoft.com/";

    private final static char[] DELIMITERS = {' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};

    public static void main(String[] args){

        final HtmlPageBody body = new HtmlDownloader(URL).download();
        final HtmlPageWordStats stat = new WordStats(body).count(DELIMITERS);

        stat.printResult();

    }
}

