package com.imooc.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhaobin11@baidu.com
 */
public class RunTest {

    @Test
    public void submitTest() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(1000 * 2);
            return 2 * 5;
        });

        // 阻塞方法，直到任务有返回值才向下执行
        System.out.println(future.get());
    }

    @Test
    public void executeTest() {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        threadPool.execute(() -> {
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer num = 2 * 5;
            System.out.println("执行结果: " + num);
        });

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
