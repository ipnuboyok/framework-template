package ${package};

import com.alibaba.fastjson2.JSON;
import ${package}.biz.TestBiz;
import ${package}.domain.TestDTO;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

public class Test1 extends TestBase {
    @Resource
    private TestBiz testBiz;
    @Test
    public void Test1(){
        List<TestDTO> testDTOS = testBiz.get();
        System.out.println(JSON.toJSONString(testDTOS));
    }
}
