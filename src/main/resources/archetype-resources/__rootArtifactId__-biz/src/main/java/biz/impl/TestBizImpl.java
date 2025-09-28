package ${package}.biz.impl;

import ${package}.domain.TestDTO;
import ${package}.service.TestService;
import ${package}.biz.TestBiz;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public List<TestDTO> get() {
        return service.get();
    }
}
