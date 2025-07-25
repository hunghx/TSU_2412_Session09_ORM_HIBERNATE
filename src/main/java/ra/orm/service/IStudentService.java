package ra.orm.service;

import ra.orm.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents(int page, int size);
    int totalPage(int size); // Phương thức để lấy tổng số trang dựa trên kích thước trang
    void initData(); // Phương thức để khởi tạo dữ liệu mẫu
    void addStudent(Student student); // Phương thức để thêm sinh viên mới
    void updateStudent(Student student); // Phương thức để cập nhật thông tin sinh viên
    void deleteStudent(Integer id); // Phương thức để xóa sinh viên theo ID
    Student getStudentById(Integer id); // Phương thức để lấy thông tin sinh viên theo ID
}
