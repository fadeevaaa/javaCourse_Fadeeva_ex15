import java.util.Arrays;
import java.util.List;

public class Text {
    String text;
    List<String> bigWords;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text.replaceAll("\\p{Punct}", " ").toLowerCase();
    }

    public void setBigWords() {
        List<String> textArray = Arrays.asList(toString().split(" "));
        bigWords = textArray.stream().filter(e -> e.length() > 6).toList();
    }
}
