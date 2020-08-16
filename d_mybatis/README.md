MyBatis的环境搭建：
1. 创建Maven工程并导入坐标
2. 创建实体类和dao的接口
3. 创建MyBatis的主配置文件SqlMapConfig.xml
4. 创建映射配置文件IUserDao.xml

环境搭建的注意事项：
1. MyBatis的映射配置文件位置必须和dao接口的包结构相同
2. 映射配置文件的mapper标签的namespace属性的取值必须是dao接口的全限定类名
3. 映射配置文件的操作配置，id属性的取值必须是dao接口的方法名
4. IUserDao和IUserMapper是一样的，mapper是MyBatis持久层的操作接口名称和映射文件的后缀

MyBatis是支持写dao的实现类的，但是很少写