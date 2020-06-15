### 使用json, ajax, mvc的这种交互模式, 其实主要的点, 还是聚集在json和ajax的一个问题上.
- 使用json,　在web环境下面, 就是要使用restcontroller, 然后返回json的字符串, 我们在这个时候, 还要将对象等转换成json字符串,一般使用Jackson或者是fastjson, 推荐使用Jackson.
- 使用ajax的话, 就是在前端的层面, 调用后端的方法, 然后前端调用这个方法之后, 获取了后端返回的数据, 不用去刷新页面, 而局部的信息获得了更新, 这就是前端ajax的一个特点, ajax+json, 可以给我们的页面提供更好的交互感, 然后就是更加容易实现页面交互分离.
- 当前项目之中的boot-swagger-mail-quartz-mongo-redis模块, 就是实现了json+ajax的工作模式. 只不过使用的框架是Springboot, 而这个使用的是springmvc.