package aleksey.liquibase.service;


import aleksey.liquibase.dto.UserRequest;
import aleksey.liquibase.dto.UserResponse;
import aleksey.liquibase.mapper.UserMapper;
import aleksey.liquibase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;


    public UserResponse create(UserRequest user) {
        return UserMapper.map(repository.save(UserMapper.map(user)));
    }

    public UserResponse get(Long id) {
        return UserMapper.map(repository.findById(id).orElseThrow(
                () -> new RuntimeException("not found by id")
        ));
    }

    public UserResponse delete(Long id) {
        return UserMapper.map(repository.deleteUserById(id).orElseThrow(
                () -> new RuntimeException("not found by id")
        ));
    }



}
