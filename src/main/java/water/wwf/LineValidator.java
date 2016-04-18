package water.wwf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by steve on 11/19/15.
 */
public class LineValidator {

    private Pattern pattern = null;
    private Matcher matcher = null;

    private static final String LINE_PATTERN = "^LSC.*";

    public LineValidator(){
        pattern = Pattern.compile(LINE_PATTERN);
    }

    public boolean checkReadLine(String line){
        matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
