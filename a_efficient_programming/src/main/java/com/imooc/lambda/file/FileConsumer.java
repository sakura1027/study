package com.imooc.lambda.file;

/**
 * 文件处理函数式接口
 *
 * @author zhaobin11@baidu.com
 */
@FunctionalInterface
public interface FileConsumer {

    /**
     * 函数式接口抽象方法
     *
     * @param fileContent 文件内容字符串
     */
    void fileHandler(String fileContent);
}
