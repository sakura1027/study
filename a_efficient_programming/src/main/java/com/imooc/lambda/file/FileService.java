package com.imooc.lambda.file;

import java.io.*;

/**
 * 文件服务类
 *
 * @author zhaobin11@baidu.com
 */
public class FileService {

    /**
     * 通过url获取本地文件内容，调用函数式接口处理
     *
     * @param url
     * @param fileConsumer
     */
    public void fileHandle(String url, FileConsumer fileConsumer) throws IOException {
        // 创建文件读取流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url)));

        // 定义行变量和内容sb
        String line;
        StringBuilder sb = new StringBuilder();

        // 循环读取文件内容
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        // 调用函数式接口方法，文件内容传递给lambda表达式，实现业务逻辑
        fileConsumer.fileHandler(sb.toString());
    }
}
