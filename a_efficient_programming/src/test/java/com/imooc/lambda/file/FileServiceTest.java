package com.imooc.lambda.file;

import org.junit.Test;

import java.io.IOException;

/**
 * @author zhaobin11@baidu.com
 */
public class FileServiceTest {

    @Test
    public void test1() throws IOException {
        FileService fileService = new FileService();
        fileService.fileHandle("C:\\study\\a_efficient_programming\\src\\main\\java\\com\\imooc\\lambda\\file\\FileService.java", System.out::println);
    }
}
