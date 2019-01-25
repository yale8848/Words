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


        String test = "我你好fuck法轮功ddd肥嘟嘟操草你妈色魔s试试达赖达赖喇嘛";

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

```text
output:

我你好*******ddd肥嘟嘟******s试试******[fuck, 操草你妈, 达赖喇嘛, 法轮功, 色魔, 达赖]
true
[fuck, 操草你妈, 达赖喇嘛, 法轮功, 色魔, 达赖]


```


### todo 

- 过滤无效词
- 英文大小写
- 混淆字词


### dict from

https://github.com/observerss/textfilter


