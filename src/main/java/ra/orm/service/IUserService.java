package ra.orm.service;

import ra.orm.dto.request.UserRequestDto;
import ra.orm.dto.response.UserResponseDto;

public interface IUserService {
    UserResponseDto addUser(UserRequestDto request);
}
