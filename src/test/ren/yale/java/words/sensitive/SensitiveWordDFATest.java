package ren.yale.java.words.sensitive;

import ren.yale.java.words.excep.NotInitException;

import static org.junit.Assert.*;

/**
 * Created by yale on 2019/1/25.
 */
public class SensitiveWordDFATest {

    @org.junit.Test
    public void init() {

        SensitiveWord sensitiveWord = new SensitiveWordDFA();
        sensitiveWord.init();
        String test = "我fuck法轮功";
        SensitiveResult rep  = null;
        try {
            rep = sensitiveWord.replaceSensitiveWord(test,'*');
            System.out.println(rep.isHaveSensitiveWord()?rep.getAntiSensitive()+rep.getSensitiveWords().toString():test);
        } catch (NotInitException e) {
            e.printStackTrace();
        }
    }
}