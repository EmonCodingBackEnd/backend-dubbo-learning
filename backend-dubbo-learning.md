# backend-dubbo-learning

Dubbo学习：

Dubbo3: https://www.bilibili.com/video/BV1FW4y147Cx/?spm_id_from=333.337.search-card.all.click&vd_source=b850b3a29a70c8eb888ce7dff776a5d1

Dubbo2: https://www.bilibili.com/video/BV1ns411c7jV/?p=2&spm_id_from=pageDriver 【推荐】

https://www.bilibili.com/video/BV1ns411c7jV?p=19&spm_id_from=pageDriver&vd_source=b850b3a29a70c8eb888ce7dff776a5d1

Dubbo3源码解析：https://www.bookstack.cn/read/songxiaosheng-Dubbo3/44b948bf30699ee1.md

学习视频：

https://www.bilibili.com/video/BV1bX4y1G7SF/?spm_id_from=333.788.recommend_more_video.3&vd_source=b850b3a29a70c8eb888ce7dff776a5d1

ORM->MVC->RPC->SOA
RPC【Remote Procedure Call】，远程过程调用。

RPC的核心：像调用本地方法一样调用远程服务。

RPC的作用：屏蔽包括组包解包和数据发送接收等远程调用细节。





RPC两个核心模块：通讯，序列化。

RPC框架有很多，如：
dubbo、gRPC、Thrift、HSF（High Speed Service Framework）



Dubbo官网：

https://cn.dubbo.apache.org/zh-cn/index.html

[Dubbo2.7文档](https://cn.dubbo.apache.org/zh-cn/docs3-v2/java-sdk/version/)

[Dubbo3.x文档](https://cn.dubbo.apache.org/zh-cn/docs3-v2/java-sdk/version/)

[Dubbo3.x升级与兼容性指南](https://cn.dubbo.apache.org/zh-cn/docs/migration/migration-and-compatibility-guide/)



# 1、Dubbo Admin启动

## 1.1、Dubbo Admin Docker启动：

dubbo-admin的docker地址：https://hub.docker.com/repository/docker/apache/dubbo-admin

1. 下载`application.properties`

https://github.com/apache/dubbo-admin/blob/0.5.0/dubbo-admin-server/src/main/resources/application.properties

并修改zookeeper的配置。

2. 创建Docker本地volume

```bash
$ mkdir /usr/local/dockerv/dubbo-admin/
```

3. 把下载的`application.properties`文件放入volume目录

```properties
# [修改]
admin.registry.address=zookeeper://192.168.200.116:2181
admin.config-center=zookeeper://192.168.200.116:2181
admin.metadata-report.address=zookeeper://192.168.200.116:2181

# [新增]注册应用级
dubbo.application.register-mode=instance
```

4. 启动

```bash
# 建议第一次运行时，使用 -it  ，确认启动成功了，再使用-d后台运行。
$ docker run --rm -v /usr/local/dockerv/dubbo-admin:/config -p 38080:38080 -d apache/dubbo-admin:0.5.0
```



## 1.2、Dubbo Admin 编译启动：

1. 下载

```bash
$ git clone https://github.com/apache/dubbo-admin.git
$ git checkout develop
```

2. 修改zookeeper配置

```bash
$ vim dubbo-admin-server/src/main/resources/application.properties
```

3. 打包

```bash
$ mvn clean package -Dmaven.test.skip=true
```

4. 启动

```bash
$ mvn --projects dubbo-admin-server spring-boot:run
# 或者
cd dubbo-admin-distribution/target; java -jar dubbo-admin-0.1.jar
```

也可以不用修改zookeeper的配置，直接启动：

```bash
$ java -jar -Dadmin.registry.address=zookeeper://emon:2181 -Dadmin.config-center=zookeeper://emon:2181 -Dadmin.metadata-report.address=zookeeper://emon:2181 dubbo-admin-distribution/target/dubbo-admin-0.5.0-SNAPSHOT.jar
# 或者
$ mvn --projects dubbo-admin-server spring-boot:run -Dadmin.registry.address=zookeeper://emon:2181 -Dadmin.config-center=zookeeper://emon:2181 -Dadmin.metadata-report.address=zookeeper://emon:2181
```

5. 访问

http://localhost:38080

用户名密码： root/root

# 2、Dubbo与Curator、ZooKeeper版本

| Dubbo                 | Curator      | ZooKeeper      |
| --------------------- | ------------ | -------------- |
| Dubbo2.7.3            |              |                |
| Dubbo3.0.7-Dubbo3.1.7 | Curator5.1.0 | ZooKeeper3.7.0 |
| Dubbo3.0.3-Dubbo3.0.5 | Curator5.1.0 | ZooKeeper3.6.0 |
| Dubbo3.0.2            | Curator5.0.0 | ZooKeeper3.6.0 |



# 3、Dubbo VS X

## 3.1、Dubbo与SpringCloud

- Dubbo强调的是服务调用的速度和易用性
- SpringCloud强调的是微服务治理
- Dubbo和SpringCloud结合是目前的主流做法
- Dubbo相当于SpringCloud中的Ribbon+Feign

## 3.2、Dubbo与Thrift

- Dubbo与Thrift都是强调服务调用的速度
- Dubbo提供了包括本地存根、Mock等各种服务特性
- Dubbo社区比Thrift社区更活跃



# 4、其他

## 1、dubbo配置文件优先级：
-D参数 > application.yml > dubbo.properties

## 2、timeout配置优先级

- 方法级别优先，接口级别次之，全局配置再次之。
- 如果级别一样，则消费方优先，提供方次之。

超时优先级：consumer方法级>provider方法级>consumer接口级>provider接口级>consumer级>provider级

