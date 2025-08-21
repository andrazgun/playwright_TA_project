package mapper;

import context.RandomUser;
import dto.CustomerDto;

public class UserMapper {
    public static CustomerDto toDto(RandomUser randomUser) {
        return new CustomerDto(
                randomUser.firstName(),
                randomUser.lastName(),
                randomUser.email(),
                randomUser.username(),
                randomUser.password()
        );
    }
}
