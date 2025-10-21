package ${package}.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("${package}.dao.mapper")
@ComponentScan({"${package}"})
@EnableDiscoveryClient  // 启用服务发现
@EnableFeignClients(basePackages = "${package}.service.feign")     // 启用 Feign 客户端
public class Application {
    public static void main(String[] args) {
        String profile = System.getProperty("spring.profiles.active");
        System.out.println("=== Maven Profile: " + System.getProperty("build.env") + " ===");
        System.out.println("=== Spring Profile: " + profile + " ===");
        SpringApplication.run(Application.class, args);
        System.out.println("server start is success");
    }
}