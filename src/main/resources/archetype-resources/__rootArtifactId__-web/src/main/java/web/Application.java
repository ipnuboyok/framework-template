package ${package}.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("${package}.dao.mapper")
@ComponentScan({"${package}"})
public class Application {
    public static void main(String[] args) {
        String profile = System.getProperty("spring.profiles.active");
        System.out.println("=== Maven Profile: " + System.getProperty("build.env") + " ===");
        System.out.println("=== Spring Profile: " + profile + " ===");
        SpringApplication.run(Application.class, args);
        System.out.println("server start is success");
    }
}