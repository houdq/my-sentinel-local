# my-sentinel

### 服务端启动

官网 release 地址： https://github.com/alibaba/Sentinel/releases

**启动**

```
➜  ~ java -jar -Dserver.port=10086 sentinel-dashboard-2.0.0-alpha-preview.jar

```
### 客户端启动

maven依赖

```xml
<dependency>
    <groupId>com.alibaba.csp</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
    <version>2021.1</version>
</dependency>
```
**sentinel配置**

```yaml
spring:
  cloud:
    sentinel:
      transport:
        dashboard: localhost:10086
```
**启动类添加注解**

```java

@SpringBootApplication
public class SentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
    }

}
```

### 自定义


controller添加注解
```java
@RestController
public class TestController {

    @GetMapping("/test")
    @SentinelResource(value = "test", blockHandler = "testBlockHandler")
    public String test() {
        return "test";
    }

    public String testBlockHandler(BlockException e) {
        return "testBlockHandler";
    }
}
```

### 查看服务端
启动服务端，启动客户端，访问客户端接口，访问sentinel控制台，查看接口调用情况
![image](https://github.com/houdq/blog/assets/9412449/141f2995-2033-4c23-92dc-bb83a307a875)
