package com.imooc.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaobin11@baidu.com
 */
public class ThreadVs {

    @Test
    public void oldHandle() throws InterruptedException {
        for (int request = 1; request <= 100; request++) {
            new Thread(() -> {
                System.out.println("文档处理开始");
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束");
            }).start();
        }

        Thread.sleep(1000 * 10);
    }

    @Test
    public void newHandle() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int request = 1; request <= 100; request++) {
            threadPool.execute(() -> {
                System.out.println("文档处理开始");
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束");
            });
        }

        Thread.sleep(1000 * 1000);
    }
}
