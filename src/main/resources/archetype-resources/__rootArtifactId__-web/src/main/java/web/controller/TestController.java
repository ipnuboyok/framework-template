package ${package}.web.controller;

import ${package}.domain.TestDTO;
import ${package}.service.TestService;
import ${package}.biz.TestBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class TestController {
    @Resource
    private TestBiz testBiz;

    @GetMapping("/test")
    public List<TestDTO> test() {
        return testBiz.get();
    }
}
