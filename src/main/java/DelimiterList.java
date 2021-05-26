import java.util.Arrays;
import java.util.HashSet;

public class DelimiterList {
    public final HashSet<Character> delimiters;

    public DelimiterList(Character[] delimiterSet) {
        this.delimiters = new HashSet(Arrays.asList(delimiterSet));
    }
}
