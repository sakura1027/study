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

项目DB数据：
```
create database if not exists easy_mybatis;
use easy_mybatis;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` datetime default NULL COMMENT '生日',
  `sex` char(1) default NULL COMMENT '性别',
  `address` varchar(256) default NULL COMMENT '地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `user` (`id`,`username`,`birthday`,`sex`,`address`) values 
(41,'老王','2018-02-27 17:47:08','男','北京'),
(42,'小二王','2018-03-02 15:09:37','女','北京金燕龙'),
(43,'小二王','2018-03-04 11:34:34','女','北京金燕龙'),
(45,'传智播客','2018-03-04 12:04:06','男','北京金燕龙'),
(46,'老王','2018-03-07 17:37:26','男','北京'),
(48,'小马宝莉','2018-03-08 11:44:00','女','北京西二旗');
```