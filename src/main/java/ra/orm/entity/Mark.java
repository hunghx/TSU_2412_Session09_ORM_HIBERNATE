package ra.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Mark {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subjectName;
    private float point;
    @ManyToOne(fetch = FetchType.EAGER) // load dữ liệu ngay lập tức khi truy vấn
    @JoinColumn(name = "student_id") // 1 chiều
    private Student student;
}
