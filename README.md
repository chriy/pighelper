# 基于Hybrid+SSM的养猪信息化平台。
**从养殖户的角度来看，获取养殖新闻的途径可能有很多，**
**但是由于新闻不集中，功能不齐全，并没有那么方便。**
**该项目旨在帮助养殖户获取时事新闻，猪价信息。统计开销，画图展示，数据可视化等。**
**最终打包成混合式App安装在移动端，简化用户使用**



---



### 注意事项：

**爬虫文件全部写在util包底下。网站的url地址可能会发生变化。如果爬虫失效，请检查各个链接地址是否可用**

```java
 /**
     * 获取标题和URL
     * @return
     */
    public static List<List<String>> getItem() {
        String reqUrl = "https://www.zhuwang.cc/";//首页新闻地址
        String resource = GetNewsUtil.getSources(reqUrl);//获取网页源代码
        ....
```



---



### 1、用户登录模块。权限控制

![image](/web/img/p1.png)

### 2、爬虫获取新闻数据展示模块。这个模块实现对网络数据的实时获取

![image](/web/img/p1.png)

### 3、猪价获取模块，这个功能模块是获取每日猪价信息

![image](/web/img/p4.png)

### 4、统计功能模块。这个模块实现了对各类账单的数据统计和数据可视化展示

![image](/web/img/p3.png)

### 5、设置模块，这个功能模块实现的是对整个系统的设置

![image](/web/img/p5.png)

### 6、各类账单数据的增删改查功能

![image](/web/img/p6.png)
![image](/web/img/p7.png)
![image](/web/img/p8.png)







