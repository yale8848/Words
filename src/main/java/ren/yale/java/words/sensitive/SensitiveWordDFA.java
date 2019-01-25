package ren.yale.java.words.sensitive;

import ren.yale.java.words.excep.NotInitException;

import java.io.*;
import java.util.*;

/**
 * Yale
 * create at: 2019-01-24 11:51
 **/
public class SensitiveWordDFA implements SensitiveWord{

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static HashMap sensitiveWordMap;
    private static final String END_KEY = "en";
    private static final String DICT = "keyword.txt";

    @Override
    public void init(InputStream inputStream) {

        try {
            Set<String> words = new HashSet<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null){
                if (line.trim().length()>0){
                    words.add(line.trim());
                }
            }
            br.close();
            init(words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        init(this.getClass().getResourceAsStream("/"+DICT));
    }

    private void checkInit() throws NotInitException{
        if (sensitiveWordMap == null){
            throw new NotInitException("not init SensitiveWord");
        }
    }

    @Override
    public void init(Set<String> sensitiveWordSet) {
        sensitiveWordMap = new HashMap(getInitCapacity(sensitiveWordSet),DEFAULT_LOAD_FACTOR);

        sensitiveWordSet.forEach(v->{
            Map charNode = null;
            Map sm = sensitiveWordMap;
            for(int i =0 ;i < v.length();i++){
                char ch = v.charAt(i);
                charNode = (Map) sm.get(ch);
                if (charNode == null){
                    charNode = new HashMap();
                    sm.put(ch,charNode);
                }
                sm = charNode;
                if (!isEnd(sm)){
                    sm.put(END_KEY,i == v.length()-1);
                }
            }
        });


    }


    private int getInitCapacity(Set<String> sensitiveWordSet){
        Set<Character> setChar = new HashSet<>();
        sensitiveWordSet.forEach(v->{setChar.add(v.charAt(0));});
        float ft = ((float)setChar.size() / DEFAULT_LOAD_FACTOR) + 1.0F;
        return (int)ft;
    }

    @Override
    public boolean contains(String txt, SensitiveMatchType matchType)throws NotInitException {

        checkInit();

        for (int i = 0 ;i < txt.length();i++ ){
           int index = check(txt,i,matchType);
           if (index!=-1&&index-i>1){
               return true;
           }
        }
        return false;
    }

    @Override
    public boolean contains(String txt) throws NotInitException {
        return contains(txt,SensitiveMatchType.MaxMath);
    }

    private boolean isEnd(Map mp){
        Object find =  mp.get(END_KEY);
        if (find == null){
            return false;
        }
        return (boolean) find;
    }

    private int check(String txt, int startIndex, SensitiveMatchType matchType)throws NotInitException{

        Map tmp = sensitiveWordMap;
        int index = -1;
        for (int i = startIndex ;i < txt.length();i++ ){
            Map sm = (Map) tmp.get(txt.charAt(i));
            if (sm == null){
                break;
            }
            index = i;
            tmp = sm;
            if (isEnd(tmp)&& matchType == SensitiveMatchType.MinMatch){
                return index;
            }
        }

        return isEnd(tmp)?index:-1;
    }

    @Override
    public List<String> getSensitiveWord(String txt, SensitiveMatchType matchType) throws NotInitException{

        checkInit();

        List<String> findWords = new ArrayList<>();
        for (int i = 0 ;i < txt.length();i++ ){
            int index = check(txt,i,matchType);
            if (index!=-1&&index-i>=1&&!findWords.contains(txt.substring(i,index+1))){
                findWords.add(txt.substring(i,index+1));
            }
            if (index!=-1&& index!=i){
                i = index;
            }
        }
        Collections.sort(findWords,(o1, o2)->{return  o2.length()-o1.length();});
        return findWords;
    }

    @Override
    public List<String> getSensitiveWord(String txt) throws NotInitException{
        checkInit();
        return getSensitiveWord(txt,SensitiveMatchType.MaxMath);
    }

    private String getRepeatChars(char replaceStr , int length){
        StringBuilder sb = new StringBuilder();
        for (int i =0 ;i < length;i++){
            sb.append(replaceStr);
        }
        return sb.toString();
    }


    public SensitiveResult replaceSensitiveWord(String txt, char replaceStr, SensitiveMatchType matchType) throws NotInitException{
        checkInit();
        List<String> findWords = getSensitiveWord(txt,matchType);
        for (String v:findWords) {
            txt = txt.replaceAll(v,getRepeatChars(replaceStr,v.length()));
        }
        SensitiveResult sensitiveResult = new SensitiveResult();
        sensitiveResult.setHaveSensitiveWord(findWords.size()>0);
        sensitiveResult.setSensitiveWords(findWords);
        sensitiveResult.setAntiSensitive(txt);
        return sensitiveResult;
    }

    @Override
    public SensitiveResult replaceSensitiveWord(String txt, char replaceStr)throws NotInitException {
        checkInit();
        return replaceSensitiveWord(txt,replaceStr,SensitiveMatchType.MaxMath);
    }
}
