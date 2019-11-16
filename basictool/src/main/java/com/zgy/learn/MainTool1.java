package com.zgy.learn;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 一些常用的类库的使用例子, 包含了
 * UUID, Array.asList的使用, 数据源的定义
 * 线程池的定义, 使用, 任务的定义, 任务执行结果的获取
 */
public class MainTool1 {
    // 定義一個全局的數據源
    private static DataSource dataSource;
    // 定義一個全局的uuid生成器
    private static UUID uuid = UUID.randomUUID();

    public static void main(String[] args) throws IOException {
        // 數據庫測試
        DataSource data = dataSource();
        System.out.println(data.toString());

        // 使用Arrays.asList
        useAsList();

        // 使用UUID
        useUUID();

        // 使用線程池
        singleExecRunableResult();
        Integer res = singleExecCallableResult();
        System.out.println(res);
        System.out.println("大雜燴線程池執行結果長度: " + fixedExecCallableResult().size());

        // 使用隊列
        System.out.println(getBlockingDq());

    }

    /**
     * 獲取一個數據源
     *
     * @return 數據源
     * @throws IOException
     */
    private static DataSource dataSource() throws IOException {
        SimpleDriverDataSource source = new SimpleDriverDataSource();
        source.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&useSSL=false");
        source.setUsername("root");
        source.setPassword("123456");
        source.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource = source;
        return dataSource;
    }

    /**
     * 使用Arrays.asList方法
     */
    private static void useAsList() {
        System.out.println("use Arrays.asList()");
        String[] ss = {"hi", "nihao!", "fsafa", "MG中国", "中国"};
        List<String> ls = Arrays.asList(ss);
        System.out.println(ls.size());
        System.out.println(ls.get(0));
        System.out.println("==========================================================\n\n");
    }

    /**
     * 使用UUID
     */
    private static void useUUID() {
        System.out.println("use UUID ");
        if (null == uuid)
            System.out.println("mb");
        System.out.println(uuid);
        System.out.println(uuid.toString());
        System.out.println(uuid.toString().replace("", "-"));
        System.out.println(uuid.toString().replace("-", ""));
        System.out.println(uuid.getMostSignificantBits());
        System.out.println(uuid.getLeastSignificantBits());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");

    }


    /**
     * 把任務放進線程池，這個任務不需要返回結果
     */
    private static void singleExecRunableResult() {
        ExecutorService e = Executors.newSingleThreadExecutor();

        e.submit(new SubTask(uuid.getMostSignificantBits(), "任務1"));
        System.out.println("singleExecRunableResult()執行狀態:" + e.isShutdown());
        // 停止線程池服務
        e.shutdown();
        System.out.println("singleExecRunableResult()執行狀態:" + e.isShutdown());
        System.out.println("==========================================================\n\n");
    }

    /**
     * 把任務放進線程池，這個任務需要返回結果
     *
     * @return 線程運行的結果
     */
    private static Integer singleExecCallableResult() {
        ExecutorService e = Executors.newSingleThreadExecutor();

        Future<Integer> ss = e.submit(new SubCallTask(uuid.getMostSignificantBits(), "callable任務"));
        Integer s = 0;
        try {
            // 線程(任務)執行的結果
            s = ss.get();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }
        return s;
    }

    // 把執行結果返回到一個List之中
    public static List fixedExecCallableResult() {
        List l = new ArrayList();
        // 設置最大是10個
        ExecutorService service = Executors.newFixedThreadPool(10);
        SubCallTask<String> sc1 = new SubCallTask<>(100L, "任務1");
        SubCallTask<Integer> sc2 = new SubCallTask<>(101L, "任務2");
        SubCallTask<Object> sc3 = new SubCallTask<>(102L, "任務3");
        SubTask sc4 = new SubTask(103L, "任務4");
        Integer i = 0;

        // 任務提交
        Future f1 = service.submit(sc1);
        Future f2 = service.submit(sc2);
        Future f3 = service.submit(sc3);
        Future f4 = service.submit(sc4, i);
        try {
            l.add(f1.get());
            // 設置獲取結果超時時間
            l.add(f2.get(2000, TimeUnit.MILLISECONDS));
            l.add(f3.get());
            l.add(f4.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return l;
    }


    /**
     * 獲取一個雙端隊列
     *
     * @param <T> 某種類型T
     * @return 隊列
     */
    private static <T> Deque<T> getDueue() {
        Deque<T> dq = new LinkedBlockingDeque<T>();
        return dq;
    }

    /**
     * 雙端隊列的基本操作
     *
     * @return 雙端隊列
     */
    public static LinkedBlockingDeque<String> getBlockingDq() {
        List<String> s = Arrays.asList("nihoao", "china", "mibiadsf", "mdfsfa", "強國", "強國論壇", "三個代表");
        LinkedBlockingDeque<String> dq = (LinkedBlockingDeque) getDueue();
        dq.addAll(s);
        System.out.println(dq.size());
        // 頭部添加
        dq.addFirst("MSK金");
        printDeque(dq, "在頭部添加，然後打印Queue: ");


        System.out.println("尾部添加： fsp");
        dq.offer("fsp");
        System.out.println("輸出隊列頭部的元素， 但是不刪除， 使用element(): 有相同作用的有getFirst()方法，" +
                "getLast()方法也是不remove(), peek(), peekFirst()也是不remove的" + dq.element());
        System.out.println("是否存在fsp :" + dq.contains("fsp"));
        // 頭部移除
        dq.removeFirst();
        System.out.println("Queue長度：" + dq.size());
        return (LinkedBlockingDeque) dq;

    }

    /**
     * 打印隊列信息
     *
     * @param dq  隊列
     * @param msg 要輸出的消息
     * @param <T> 某種類型的隊列
     */
    private static <T> void printDeque(Deque<T> dq, String msg) {
        Iterator<T> it = dq.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().toString() + ", ");
        }
        System.out.println(String.format("%s, %s", msg, sb.substring(0, sb.length() - 1)));
    }


}

/**
 * 不需要結果的任務
 */
class SubTask implements Runnable {
    private Long id;
    private String taskName;

    public SubTask() {
    }

    public SubTask(Long id, String taskName) {
        this.id = id;
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                '}';
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.toString());
    }
}

/**
 * 需要返回結果的任務
 */
class SubCallTask<T> implements Callable<T> {
    private Long id;
    private String taskName;

    public SubCallTask() {
    }

    public SubCallTask(Long id, String taskName) {
        this.id = id;
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                '}';
    }

    @Override
    public T call() {
        Random random = new Random(1000);
        Integer s = random.nextInt(20);
        System.out.println(this.toString());
        return (T) s;
    }
}

