package ${package}.service;

import org.springframework.stereotype.Service;
import ${package}.domain.TestDTO;

import java.util.List;

@Service
public interface TestService {
     List<TestDTO> get();
}
