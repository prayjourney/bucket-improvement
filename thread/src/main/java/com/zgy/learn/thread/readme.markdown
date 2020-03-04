simplejuc: 简单使用了juc的lock, aqs的方式实现的多线程买票

threadbasic: 和Thread,Runnable相关的，启动，停止，观察状态，让步，等待，停止等基本的线程操作


tradmulti: traditional multiple-thread 传统的多线程，使用synchronized关键字对方法加锁，
            对块加锁，实现共享变量的正常访问，还使用了volatile的原子性和可见性


tradprocon: traditional produce and consumer，使用传统的方式实现生产者和消费者问题