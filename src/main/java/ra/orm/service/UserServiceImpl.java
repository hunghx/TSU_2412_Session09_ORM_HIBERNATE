package ra.orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.orm.dto.request.UserRequestDto;
import ra.orm.dto.response.UserResponseDto;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private CloudService cloudService;
    @Override
    public UserResponseDto addUser(UserRequestDto request) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setFullName(request.getFullName());
        userResponseDto.setDateOfBirth(request.getDateOfBirth());
        userResponseDto.setEmail(request.getEmail());
        userResponseDto.setPhoneNumber(request.getPhoneNumber());
        if (request.getAvatar().getSize() > 0){
            // upload
            String url = cloudService.uploadFileToCloudinary(request.getAvatar());
            userResponseDto.setAvatarUrl(url);
        }
        return userResponseDto;
    }
}
