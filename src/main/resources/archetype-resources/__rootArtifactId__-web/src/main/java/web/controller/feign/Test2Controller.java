package ${package}.web.controller.feign;


import ${package}.api.domain.request.UserRequestDTO;
import ${package}.api.domain.response.UserResponseDTO;
import ${package}.biz.TestBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/test2")
@Slf4j
public class Test2Controller {
    @Resource
    private TestBiz testBiz;

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        log.info("id={}通过test1获取信息",id);
        return testBiz.getUserById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO request) {
        // 模拟业务处理
        ResponseEntity<UserResponseDTO> response = testBiz.createUser(request);
        log.info("createUser request={},response={}", request,response);
        return response;
    }
}
