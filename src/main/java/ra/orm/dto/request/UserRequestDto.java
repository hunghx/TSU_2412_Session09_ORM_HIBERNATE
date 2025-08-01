package ra.orm.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ra.orm.validator.NotName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Getter
@Setter
public class UserRequestDto {
    @NotBlank(message = "Họ tên không được để trống")
    @NotName
    private String fullName;
    @NotNull(message = "Ngày sinh không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Email không được để trống")
//    @Email(message = "Email không hợp lệ")
    @Pattern(regexp = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$", message = "Email không hợp lệ")
    private String email;
    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^\\d{10,11}$", message = "Số điện thoại không hợp lệ")
    private String phoneNumber;
}
