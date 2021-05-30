public class Main {

    private final static String URL = "https://www.simbirsoft.com/";

    private final static char[] DELIMITERS = {' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};

    public static void main(String[] args){

        final HtmlPage page = new Scratch(URL).download();
        final HtmlPageWordStats stat = new WordsCounter(page.getBody()).count(DELIMITERS);

        stat.printResult();

    }
}

