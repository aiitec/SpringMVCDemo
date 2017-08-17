# SpringMVCDemo

## 介绍
这个来自另外一个学习项目，向原作者致敬！
这是一个增加了规范、技术底层方面迭代更新的demo，公开部分主要用于准企业级的方案框架和公司内部机试题目需要。
因为改动量太大，所以没有从原库中fork（几乎没有合并的可能）。
请先阅读原文的介绍如何部署，再看后面我们的介绍新规范要求

## 原文介绍

这是我个人在学习过程中整理的一个SpringMVCDemo项目。

如果要运行这个项目，首先要创建一个"springdemo"数据库，注意选择utf-8格式，然后将springdemo.sql导入到数据库中。

如果需要查看完整的教程，请访问[Gaussic OSChina](http://my.oschina.net/gaussik/blog/385697) 。

最好使用最新版本的 IntelliJ IDEA, JDK 1.8.x，还有Tomcat8.x。

任何由升级带来的问题，请查阅[Spring Framework Reference](http://docs.spring.io/spring/docs/4.3.0.BUILD-SNAPSHOT/spring-framework-reference/htmlsingle/)。

如果你有什么问题，或者宝贵的意见，可以在Issues中提出，我会及时回应。谢谢关注 :)

此外，还有一个旧的 spring 3.2.0 版本的项目：[See the spring3.2 branch](https://github.com/gaussic/SpringMVCDemo/tree/spring3.2)

欢迎访问我的个人博客首页：[Gaussic](http://gaussic.top)

## 本项目介绍
demo是Spring最新的4.2.6版本。做了如下操作：
1.增加Simple-spring-memcached作为缓存
2.目录分层做到了MVC分层，M层进一步分层，符合企业级的架构
3.包名换成公司规范要求

###1.MVC框架里面，我们根据MVC以及下面的分层要求
划分号目录，保持调用结构：
####Controller层：
Controller，对应@Controller注解，只做路由转发+耦合view层的东西（输出html或者json）
####view层
html或者json等数据格式，HTML使用JSP模板，json格式通过对象方式，然后在controller里面一行代码转换成json，根据对象命名，例如用户信息为UserInfo
###model层
业务逻辑和模型，M层再进一步分层ABCR：
A层：Application，简写App，对应@Service注解，包含有参数检查，权限控制，事务控制，业务流程入口。
B层：Business，简写biz，对应@Service注解，包含业务逻辑处理的主要代码、流程描述
C层（为了避免误会，以后都称为Component层、组件层）：Component，没有简写，对应@Component注解，包含逻辑的小零件，方便业务层组合逻辑。如果有对外的API调用等等也使用这个注解并且在此归类
R层：Repository，没有简写，SQL操作对应@Repository注解，包含数据库操作，Dao，model对象等。数据对象对应@Entity注解，
公用工具包，不通过Spring管理的，以其他方式管理，目录结构在业务的包下独立存在，例如com.aiitec.user，标准的结构参考例子如下：
```
├─controller
│      BlogController.java
│      MainController.java
│
├─model
│  ├─app
│  │      LoginApp.java
│  │
│  ├─biz
│  │      LoginBiz.java
│  │
│  ├─comm
│  │      UserMap.java
│  │      UserReqBody.java
│  │      UserRespBody.java
│  │
│  ├─component
│  │      PasswordComponent.java
│  │      UserInfoComponent.java
│  │
│  ├─entity
│  │      BlogEntity.java
│  │      UserEntity.java
│  │
│  └─repository
│          BlogRepository.java
│          UserRepository.java
└─view
    └─object
            UserInfo.java
```
2.架构里面，要维持自上而下的调用架构，Controller->A->B->C->R,允许同级调用，不允许调用上级（例如不允许C-->Controller）

3.不同的子系统，通过不同包名区分，可能以jar包方式（可能没有源码）提供，每个包的子系统可能包括以上提到的所有目录结构。
例如com.aiitec.user, com.aiitec.goods、com.aiitec.order等，允许跨包调用、下级调用、同级调用，但是同样不允许调用上级。

