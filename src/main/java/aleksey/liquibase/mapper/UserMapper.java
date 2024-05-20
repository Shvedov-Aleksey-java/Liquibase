package aleksey.liquibase.mapper;


import aleksey.liquibase.dto.UserRequest;
import aleksey.liquibase.dto.UserResponse;
import aleksey.liquibase.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserResponse map(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .description(user.getDescription())
                .build();
    }

    public static User map(UserRequest user) {
        return User.builder()
                .name(user.getName())
                .description(user.getDescription())
                .build();
    }
}
