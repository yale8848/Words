package ren.yale.java.words.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Yale
 * create at: 2019-01-25 10:39
 **/
public class CharUtil {

    public static boolean isEnglish(String str) {
        String regEx = "[a-zA-Z+]";
        Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        return matcher.find();
    }

    public static boolean isChinese(String str) {
        String regEx = "[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        return matcher.find();
    }
}
