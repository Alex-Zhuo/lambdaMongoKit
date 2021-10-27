package cn.idwarf.lambdaMongoKit.util;

import java.util.regex.Pattern;

/**
 * @author alex
 * @date 2021-10-27 18:09
 */
public class PatternUtil {

    public static Pattern getPattern(String keyword, String regex) {
        return getPattern(String.format(regex, keyword));
    }

    public static Pattern getPattern(String regex) {
        return Pattern.compile(regex);
    }
}
