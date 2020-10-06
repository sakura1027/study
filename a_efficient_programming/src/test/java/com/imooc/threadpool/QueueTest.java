package com.imooc.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * @author zhaobin11@baidu.com
 */
public class QueueTest {

    @Test
    public void arrayBlockingQueue() throws InterruptedException {
        // 基于数组的有界阻塞队列
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("向队列中添加值: " + i);
        }
    }

    @Test
    public void linkedBlockingDeque() throws InterruptedException {
        // 基于链表的有界阻塞队列
        // 无参构造函数为无界队列
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>(10);

        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("向队列中添加值: " + i);
        }
    }

    @Test
    public void synchronousQueue() {
        // 同步移交阻塞队列
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        // 插入值
        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("插入成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 删除值
        new Thread(() -> {
            try {
                queue.take();
                System.out.println("删除成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
