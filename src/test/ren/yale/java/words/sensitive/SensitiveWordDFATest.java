package ren.yale.java.words.sensitive;

import static org.junit.Assert.*;

/**
 * Created by yale on 2019/1/25.
 */
public class SensitiveWordDFATest {

    @org.junit.Test
    public void init() {

        SensitiveWord sensitiveWord = new SensitiveWordDFA();

        sensitiveWord.init();

        String rep  = sensitiveWord.replaceSensitiveWord("我是习大大",'*');

        System.out.println(rep);


    }
}