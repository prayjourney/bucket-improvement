需要注意的問題
1. 角色
   有生產者,消費者,產品和緩衝區,缓冲区生产者放入,消费者取出
2. 条件
   生产者导致缓冲区满了, 那么生产者就等待, 而唤醒消费者消费
   消费者导致缓冲区空了, 那么消费者就等待, 而唤醒生产者生产
3. 关于锁
   wait, notify, notifyAll, 等待和唤醒的, 都是使用同一个锁的线程
   也就是说, 生产者和消费者, 需要使用同一个锁
   **wait和notify一定要放在一起,阻塞了消费者之后,下一句马上就要唤醒生产者
   阻塞了生产者,下面一句马上就要唤醒消费者
   wait需要有一个时间的限定**

4. 控制之处
   在何处去控制, 其实现在看来, 我们控制的话, 都是要去每一个基本的操作之中控制
   也就是说, 比如买东西, 那就从buy方法之中控制, 而多个线程去买, 它调用的就是
   run方法, 这是线程的层面, 但是归结于每一个具体的操作, 那就是buy这个方法,
   我们需要在每一个具体的操作之中, 去考虑到相关的问题, 然后直接去操作, 这样的话,
   在run方法对于线程的层面而言, 那就只是去多次执行, 或者模拟延时的概念了.
5. BlockingQueue
   **队列与速度, 这个时候不要使用可以阻塞的队列方法,take和put,使用add和remove**
6. 生产和消费的速度不同, 可能导致死锁, 这个问题应该如何去分析?
   1.使用jconsole
   2.使用线程快照在idea之中
   3.使用jps+jstack的信息
   4.使用jps+ jcmd pid Thread.print, 可以打印出来信息
 *https://blog.csdn.net/u010647035/article/details/79769177
 *https://www.cnblogs.com/wy697495/p/9757982.html
 *https://blog.csdn.net/wang0112233/article/details/83749927
 *https://blog.csdn.net/sxhong/article/details/78603671
 *https://blog.csdn.net/u010647035/article/details/79770534