## Words

> Words is for sentence util kit.

## function

- Sensitive word filter

### use

- maven

```xml
<dependency>
    <groupId>ren.yale.java</groupId>
    <artifactId>words</artifactId>
    <version>0.0.6</version>
</dependency>

```

` JDK >= 1.7 `

- code

```java

        //init
        SensitiveWord sensitiveWord = SensitiveFactory.create();
        sensitiveWord.init();


        String test = "我fuck法轮功";

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

```

### todo 

- 过滤无效词
- 英文大小写
- 混淆字词


### dict from

https://github.com/observerss/textfilter


