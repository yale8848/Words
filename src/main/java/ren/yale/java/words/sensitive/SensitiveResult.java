package ren.yale.java.words.sensitive;

import java.util.List;
import java.util.Set;

/**
 * Yale
 * create at: 2019-01-25 10:14
 **/
public class SensitiveResult {
    private boolean haveSensitiveWord;
    private List<String> sensitiveWords;
    private String antiSensitive;


    public boolean isHaveSensitiveWord() {
        return haveSensitiveWord;
    }

    public void setHaveSensitiveWord(boolean haveSensitiveWord) {
        this.haveSensitiveWord = haveSensitiveWord;
    }

    public List<String> getSensitiveWords() {
        return sensitiveWords;
    }

    public void setSensitiveWords(List<String> sensitiveWords) {
        this.sensitiveWords = sensitiveWords;
    }

    public String getAntiSensitive() {
        return antiSensitive;
    }

    public void setAntiSensitive(String antiSensitive) {
        this.antiSensitive = antiSensitive;
    }
}
