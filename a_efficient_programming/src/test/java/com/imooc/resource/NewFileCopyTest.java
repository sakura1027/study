package com.imooc.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * try-with-resource java7语法糖
 *
 * @author zhaobin11@baidu.com
 */
public class NewFileCopyTest {

    @Test
    public void copyFile() {
        // 定义输入路径和输出路径
        String originalUrl = "C:\\study\\a_efficient_programming\\lib\\FileCopyTest.java";
        String targetUrl = "C:\\study\\a_efficient_programming\\targetTest\\newTarget.txt";

        try (
                // 声明文件输入输出流
                FileInputStream originalFileInputStream = new FileInputStream(originalUrl);
                FileOutputStream targetFileOutputStream = new FileOutputStream(targetUrl)
        ) {

            // 读取的字节信息
            int content;

            // 迭代 读取/写入字节
            while ((content = originalFileInputStream.read()) != -1) {
                targetFileOutputStream.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
