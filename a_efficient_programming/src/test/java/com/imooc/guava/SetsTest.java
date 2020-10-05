package com.imooc.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.imooc.utils.JsonUtils;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Lists工具类：反转、拆分
 * Sets工具类：并集、交集、差集、所有子集、笛卡尔积
 *
 * @author zhaobin11@baidu.com
 */
public class SetsTest {

    private static final Set set1 = Sets.newHashSet(1, 2, 3, 4);

    private static final Set set2 = Sets.newHashSet(4, 5, 6);

    /**
     * 并集
     */
    @Test
    public void union() {
        System.out.println(Sets.union(set1, set2)); // [1, 2, 3, 4, 5, 6]
    }

    /**
     * 交集
     */
    @Test
    public void intersection() {
        System.out.println(Sets.intersection(set1, set2)); // [4]
    }

    /**
     * 差集：如果元素属于A且不属于B
     */
    @Test
    public void difference() {
        System.out.println(Sets.difference(set1, set2)); // [1, 2, 3]

        // 相对差集：属于A且不属于B 或者 属于B且不属于A
        System.out.println(Sets.symmetricDifference(set1, set2)); // [1, 2, 3, 5, 6]
    }

    /**
     * 所有子集
     */
    @Test
    public void powerSet() {
        // [ [ ], [ 4 ], [ 5 ], [ 4, 5 ], [ 6 ], [ 4, 6 ], [ 5, 6 ], [ 4, 5, 6 ] ]
        System.out.println(JsonUtils.toPrettyString(Sets.powerSet(set2)));
    }

    /**
     * 笛卡尔积
     */
    @Test
    public void cartesianProduct() {
        // [[1, 4], [1, 5], [1, 6], [2, 4], [2, 5], [2, 6], [3, 4], [3, 5], [3, 6], [4, 4], [4, 5], [4, 6]]
        System.out.println(Sets.cartesianProduct(set1, set2));
    }

    /**
     * 拆分
     */
    @Test
    public void partition() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        List<List<Integer>> partition = Lists.partition(list, 3);
        System.out.println(partition); // [[1, 2, 3], [4, 5, 6], [7]]
    }

    /**
     * 反转
     */
    @Test
    public void reverse() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> reverse = Lists.reverse(list);
        System.out.println(reverse); // [7, 6, 5, 4, 3, 2, 1]
    }
}
