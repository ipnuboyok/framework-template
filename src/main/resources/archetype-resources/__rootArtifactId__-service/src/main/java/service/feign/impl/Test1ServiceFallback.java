package ${package}.service.feign.impl;

import ${package}.service.feign.Test1ServiceClient;

import ${package}.api.domain.request.UserRequestDTO;
import ${package}.api.domain.response.UserResponseDTO;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Test1ServiceFallback implements Test1ServiceClient {
    @Override
    public String getUserById(Long id) {
        log.error("xx-service调用 xx-service 获取用户信息失败，用户ID: {}, 错误信息: {}",
                id, getLastException());
        return "服务暂时不可用，请稍后重试。用户ID: " + id;
    }

    /**
     * 获取最近的异常信息（需要结合异常上下文）
     */
    private String getLastException() {
        // 这里可以结合 Hystrix 或 Sentinel 的异常信息
        // 或者通过 ThreadLocal 存储最近的异常
        return "服务调用超时或不可用";
    }

    @Override
    public ResponseEntity<UserResponseDTO> createUser(UserRequestDTO request) {
        //服务不可用时执行降级逻辑
        log.error("test2-service调用 test1-service createUser失败，用户ID: {}, 错误信息: {}", JSON.toJSONString(request),"服务暂时不可用");
        UserResponseDTO fallbackResponse = UserResponseDTO.builder()
                .id(-1L)
                .name("fallback")
                .status("SERVICE_UNAVAILABLE")
                .build();
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallbackResponse);
    }
}
