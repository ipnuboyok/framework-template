package ${package}.biz.impl;

import ${package}.biz.TestBiz;
import ${package}.domain.TestDTO;
import ${package}.service.TestService;
import ${package}.service.feign.Test1ServiceClient;
import ${package}.api.domain.request.UserRequestDTO;
import ${package}.api.domain.response.UserResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhupy
 * @program: test-project
 * @description
 * @date 2025/09/25/下午7:16
 */
@Component
@Slf4j
public class TestBizImpl implements TestBiz {
    @Resource
    private TestService service;

    @Resource
    private Test1ServiceClient test1ServiceClient;

    @Override
    public List<TestDTO> get() {
        return service.get();
    }

    @Override
    public String getUserById(Long id) {
        return test1ServiceClient.getUserById(id);
    }

    @Override
    public ResponseEntity<UserResponseDTO> createUser(UserRequestDTO request) {
        return test1ServiceClient.createUser(request);
    }
}
