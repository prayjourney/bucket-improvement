# boot-mybatis-redis-activemq-shiro项目
### 工程说明
springboot 2.x 整合mybatis，redis，activemq和shiro的工程，在其中附加了mybatis需要使用到的数据库的表信息

### 分支说明
当前的所有的功能，只需要在mybatis这个分支之中运行就行了。运行时，需要支持的外部组件和中间件有：
mysql, activemq, redis,这三个中间件需要提前启动。在mybatis-druid的分支之中，
是既有mybatis的配置，也有druid的配置，但是，mybatis的配置是okay的，但是druid的配置是有问题的，
因为我们在配置druid的时候，没有使用springboot-druid-stater, 而只是使用了druid的依赖jar包，
在对于配置中的DruidDBConfig和其他的DruidStatFilter，DruidStatViewServlet应该是只写在一个config类之中，
而不是写在三个里面，所以这块有问题，现在我们只需要使用springboot-druid-stater来完成配置，
其他的DruidDBConfig，其实是可以不写的，除非是我们要使用一些比较细节的配置，常用的配置，
springboot-druid-stater已经提供了默认值。

### 接口的测试
在此项目之中，很多的接口，没有直接提供相应的前端操作页面，我们在操作的时候，在controller之中，
直接就是提供的RestController，然后结果会使用Jackson转化成String，所以可以直接使用PostMan，
PostWoman，或者RestfulToolkit的IDEA插件来实现操作，也可以配置Swagger来完成操作。


### 关于Shiro
以我现在的了解，Shiro是对于页面的访问权限的一个控制的框架，对于接口的访问权限的控制，暂时不是很清楚。
具体以后了解了，再到此处说明。