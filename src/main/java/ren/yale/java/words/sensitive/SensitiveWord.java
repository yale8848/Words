package ren.yale.java.words.sensitive;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

/**
 * Created by yale on 2019/1/24.
 */
public interface SensitiveWord {
    void init(InputStream inputStream);
    void init();
    void init(Set<String> sensitiveWordSet);
    boolean contains(String txt, SensitiveMatchType matchType);
    List<String> getSensitiveWord(String txt, SensitiveMatchType matchType);
    String replaceSensitiveWord(String txt, char replaceStr, SensitiveMatchType matchType);
    String replaceSensitiveWord(String txt, char replaceStr);

}
