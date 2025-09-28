package ${package}.service.impl;

import ${package}.domain.TestDTO;
import ${package}.service.TestService;
import ${package}.dao.entity.Test;
import ${package}.dao.entity.TestExample;
import ${package}.dao.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;
    @Override
    public List<TestDTO> get(){
        TestExample example=new TestExample();
        List<Test> tests = testMapper.selectByExample(example);
        List<TestDTO> list = tests.stream()
                .map(t -> {
                    TestDTO dto = new TestDTO();
                    dto.setId(t.getId());
                    dto.setName(t.getName());
                    return dto;
                })
                .collect(Collectors.toList());
        return list;
    }
}
