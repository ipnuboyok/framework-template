package ${package}.biz;

import ${package}.domain.TestDTO;
import ${package}.domain.TestDTO;
import ${package}.api.domain.request.UserRequestDTO;
import ${package}.api.domain.response.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 * @author zhupy
 * @program: test-project
 * @description
 * @date 2025/09/25/下午7:16
 */
public interface TestBiz {
    List<TestDTO> get();

    String getUserById(Long id);

    ResponseEntity<UserResponseDTO> createUser(UserRequestDTO request);
}
