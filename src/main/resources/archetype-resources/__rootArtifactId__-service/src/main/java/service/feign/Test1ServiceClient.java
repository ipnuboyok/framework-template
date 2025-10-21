package ${package}.service.feign;

import ${package}.api.domain.request.UserRequestDTO;
import ${package}.api.domain.response.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "test1-web", path = "/test1")
public interface Test1ServiceClient {
    // 调用路径: /test1/{id}
    @GetMapping("/{id}")
    String getUserById(@PathVariable("id") Long id);

    @PostMapping("/create")
    ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request);
}