Stream
1. 中间操作（无状态）
1.1 过滤 filter
1.2 映射 map
1.3 扁平化 flatMap
1.4 遍历 peek

2. 中间操作（有状态）
2.1 去重 distinct
2.2 跳过 skip
2.3 截断 limit
2.4 排序 sorted

3. 终端操作（短路）
3.1 所有匹配 allMatch
3.2 任意匹配 anyMatch
3.3 不匹配 noneMatch
3.4 查找首个 findFirst
3.5 查找任意 findAny

4. 终端操作（非短路）
4.1 遍历 forEach
4.2 归约 reduce
4.3 最大值 max
4.4 聚合 collect
4.5 最小值 min
4.6 计数 count


需要手动释放的物理资源
1. 文件/流资源
2. 套接字资源
3. 数据库连接资源
