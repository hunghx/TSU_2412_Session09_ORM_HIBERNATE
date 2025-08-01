package ra.orm.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.orm.dto.request.UserRequestDto;
@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequestDto request = (UserRequestDto) target;

        if (request.getFullName().trim().isEmpty()){
            errors.rejectValue("fullName", null, "Không được để trống họ tên");
        }

        if (request.getDateOfBirth() == null) {
            errors.rejectValue("dateOfBirth", null, "Không được để trống ngày sinh");
        }
        if (request.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", null, "Không được để trống email");
        } else if (!request.getEmail().matches("^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$")) {
            errors.rejectValue("email", null, "Email không hợp lệ");
        }
        if (request.getPhoneNumber().trim().isEmpty()) {
            errors.rejectValue("phoneNumber", null, "Không được để trống số điện thoại");
        } else if (!request.getPhoneNumber().matches("^\\d{10,11}$")) {
            errors.rejectValue("phoneNumber", null, "Số điện thoại không hợp lệ");
        }
    }
}
