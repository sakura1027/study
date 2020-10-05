package com.imooc.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author zhaobin11@baidu.com
 */
public class IOTest {

    @Test
    public void copyFile() throws IOException {
        CharSource charSource = Files.asCharSource(new File("C:\\study\\a_efficient_programming\\lib\\SourceTest.txt"), Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(new File("C:\\study\\a_efficient_programming\\lib\\TargetTest.txt"), Charsets.UTF_8);

        charSource.copyTo(charSink);
    }
}
