package com.imooc.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Chars;
import org.junit.Test;

/**
 * @author zhaobin11@baidu.com
 */
public class MultisetTest {

    private static final String text =
            "大江东去，浪淘尽，千古风流人物。\n" +
                    "故垒西边，人道是，三国周郎赤壁。\n" +
                    "乱石穿空，惊涛拍岸，卷起千堆雪。\n" +
                    "江山如画，一时多少豪杰。\n" +
                    "遥想公瑾当年，小乔初嫁了，雄姿英发。\n" +
                    "羽扇纶巾，谈笑间，樯橹灰飞烟灭。\n" +
                    "故国神游，多情应笑我，早生华发。\n" +
                    "人生如梦，一尊还酹江月。";

    @Test
    public void handle() {
        Multiset<Character> multiset = HashMultiset.create();

        multiset.addAll(Chars.asList(text.toCharArray()));

        System.out.println(multiset.size());
        System.out.println(multiset.count('人'));
    }
}
