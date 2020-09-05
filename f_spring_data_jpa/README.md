Repository接口是Spring data的核心接口，不提供任何方法，标记接口

public interface Repository<T, ID extends Serializable> {
}

Repository中查询方法定义规则

缺点：
1. 方法名会比较长
2. 对于复杂的查询

@Query注解
