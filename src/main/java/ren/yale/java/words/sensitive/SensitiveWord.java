package ren.yale.java.words.sensitive;

import ren.yale.java.words.excep.NotInitException;

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

    boolean contains(String txt, SensitiveMatchType matchType) throws NotInitException;
    boolean contains(String txt) throws NotInitException;

    List<String> getSensitiveWord(String txt, SensitiveMatchType matchType) throws NotInitException ;
    List<String> getSensitiveWord(String txt) throws NotInitException;

    SensitiveResult replaceSensitiveWord(String txt, char replaceStr, SensitiveMatchType matchType) throws NotInitException;
    SensitiveResult replaceSensitiveWord(String txt, char replaceStr) throws NotInitException;

}
