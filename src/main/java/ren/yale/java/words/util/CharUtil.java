package ren.yale.java.words.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Yale
 * create at: 2019-01-25 10:39
 **/
public class CharUtil {

    public static boolean isEng(String str) {
        String regEx = "[a-zA-Z+]";
        Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        boolean flg = false;
        if (matcher.find())
            flg = true;
        return flg;
    }

    public static boolean isChinese(String str) {
        String regEx = "[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        boolean flg = false;
        if (matcher.find())
            flg = true;

        return flg;
    }
    static int checkChar(char c){
        if(c >= 0x0391 && c <= 0xFFE5)
            return 0;
        if(c>=0x0000 && c<=0x00FF){
            return 1;
        }
        return 2;
    }
}
