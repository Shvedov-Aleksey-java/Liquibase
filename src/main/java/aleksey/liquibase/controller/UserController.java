package aleksey.liquibase.controller;


import aleksey.liquibase.dto.UserRequest;
import aleksey.liquibase.dto.UserResponse;
import aleksey.liquibase.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aop")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public UserResponse create(@RequestBody UserRequest request) {
        return service.create(request);
    }


    @GetMapping("{id}")
    public UserResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("{id}")
    public UserResponse delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
