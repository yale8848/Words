## Words

> Words is for sentence util kit.

### use

- maven

```xml
<dependency>
    <groupId>ren.yale.java</groupId>
    <artifactId>words</artifactId>
    <version>0.0.3</version>
</dependency>

```

- code

```java

        SensitiveWord sensitiveWord = new SensitiveWordDFA();
        sensitiveWord.init();//default dict
        String test = "我fuck法轮功";
        SensitiveResult rep  = null;
        try {
            rep = sensitiveWord.replaceSensitiveWord(test,'*');
            System.out.println(rep.isHaveSensitiveWord()?rep.getAntiSensitive()+rep.getSensitiveWords().toString():test);
        } catch (NotInitException e) {
            e.printStackTrace();
        }

```

### todo 

- 过滤无效词
- 英文大小写
- 混淆字符





