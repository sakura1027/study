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

@Data注解等于
1. @Getter
2. @Setter
3. @ToString
4. @EqualsAndHashCode

构造方法
1. @NoArgsConstructor
2. @AllArgsConstructor
3. @RequiredArgsConstructor

@NonNull: 自动生成空值校验
@Cleanup: 自动调用变量的close方法释放资源

@Builder: 自动生成构造者模式
必须加上
1. @NoArgsConstructor
2. @AllArgsConstructor
否则会遇到坑

集合变量存在初始化值时必须加上@Builder.Default注解

@Synchronized: 自动生成同步锁
@SneakyThrows: 自动生成try/catch捕捉异常
@Slf4j: 自动为类添加日志支持

线程池可选择的饱和策略
1. AbortPolicy终止策略（默认）
2. DiscardPolicy抛弃策略
3. DiscardOldestPolicy抛弃旧任务策略
4. CallerRunsPolicy调用者运行策略