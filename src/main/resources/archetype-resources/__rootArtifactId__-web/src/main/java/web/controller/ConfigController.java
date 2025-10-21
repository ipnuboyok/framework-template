package ${package}.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Slf4j
public class ConfigController {
    @Value("${esc.d}{custom.config:default value}")  // 从Nacos读取 custom.config 的值
    private String configValue;

    @Value("$${esc.d}{spring.application.name:unknown}")
    private String appName;

    @GetMapping("/config")
    public String getConfig() {
        log.info("appName=",appName);
        return "从Nacos获取的配置: " + configValue;
    }
}
