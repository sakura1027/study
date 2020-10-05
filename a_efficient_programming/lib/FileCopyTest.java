package com.imooc.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhaobin11@baidu.com
 */
public class FileCopyTest {

    @Test
    public void copyFile() {
        // 定义输入路径和输出路径
        String originalUrl = "";
        String targetUrl = "";

        // 声明文件输入输出流
        FileInputStream originalFileInputStream = null;
        FileOutputStream targetFileOutputStream = null;

        try {
            originalFileInputStream = new FileInputStream(originalUrl);
            targetFileOutputStream = new FileOutputStream(targetUrl);

            // 读取的字节信息
            int content;

            // 迭代 读取/写入字节
            while ((content = originalFileInputStream.read()) != -1) {
                targetFileOutputStream.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (targetFileOutputStream != null) {
                try {
                    targetFileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (originalFileInputStream != null) {
                try {
                    originalFileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
