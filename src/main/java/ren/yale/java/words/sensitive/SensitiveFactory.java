package ren.yale.java.words.sensitive;

/**
 * Yale
 * create at: 2019-01-25 11:50
 **/
public class SensitiveFactory {


    public static SensitiveWord create(){
        return new SensitiveWordDFA();
    }
}
