package ren.yale.java.words.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yale on 2019/1/25.
 */
public class CharUtilTest {

    @Test
    public void checkChar() {

        String aa="sdadfα┇は안中国-@*,.ss";
        char[] charArray = aa.toCharArray();
        for (char c : charArray) {
            boolean cnorEn = CharUtil.isEng(String.valueOf(c));
            System.out.println(c+":"+cnorEn);
        }
    }
}