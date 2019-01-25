package ren.yale.java.words.sensitive;

import ren.yale.java.words.excep.NotInitException;

import static org.junit.Assert.*;

/**
 * Created by yale on 2019/1/25.
 */
public class SensitiveWordDFATest {

    @org.junit.Test
    public void init() {

        //init
        SensitiveWord sensitiveWord = SensitiveFactory.create();
        sensitiveWord.init();


        String test = "我你好fuck法轮功";

        //replace sensitive word
        try {
            SensitiveResult rep = sensitiveWord.replaceSensitiveWord(test,'*');
            System.out.println(rep.isHaveSensitiveWord()?rep.getAntiSensitive()+rep.getSensitiveWords().toString():test);
        } catch (NotInitException e) {
            e.printStackTrace();
        }

        //check have contains sensitive word
        try {
            System.out.println(sensitiveWord.contains(test));
        } catch (NotInitException e) {
            e.printStackTrace();
        }


        //get sensitive word
        try {
            System.out.println(sensitiveWord.getSensitiveWord(test));
        } catch (NotInitException e) {
            e.printStackTrace();
        }
    }
}