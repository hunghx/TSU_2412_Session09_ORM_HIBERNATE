package ra.orm.dto.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


import java.time.LocalDate;
@Getter
@Setter
public class UserResponseDto {
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String avatarUrl;
}
