package ra.orm.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity // Đặt tên thực thể là "students"
@Table(name = "students") // Tên bảng trong cơ sở dữ liệu
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment primary key
    private Integer id;
    @Column(name = "name", nullable = false, length = 100) // Tên cột trong bảng
    private String name;
    private String email;
    private String phone;
    private String address;
//    @Transient // Không lưu trường này vào cơ sở dữ liệu
//    private String avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Định dạng ngày tháng
    private LocalDate birthday;
}