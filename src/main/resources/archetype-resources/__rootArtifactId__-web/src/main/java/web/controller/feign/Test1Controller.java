package ${package}.web.controller.feign;


import ${package}.api.domain.request.UserRequestDTO;
import ${package}.api.domain.response.UserResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/test1")
@Slf4j
public class Test1Controller {
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        log.info("id={}通过test1获取信息",id);
        return "id="+id+"通过test1获取信息";
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO request) {
        // 模拟业务处理
        UserResponseDTO response = new UserResponseDTO(
                request.getId(),
                request.getName(),
                request.getEmail(),
                request.getAge(),
                "ACTIVE");
        log.info("createUser request={},response={}", request,response);
        return ResponseEntity.ok(response);
    }
}
