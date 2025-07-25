package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.orm.entity.Student;
import ra.orm.service.IStudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public String showStudentList(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            Model model) {
        // Trả về tên view để hiển thị danh sách sinh viên
        model.addAttribute("students", studentService.getAllStudents(page, size));
        model.addAttribute("totalPage", studentService.totalPage(size));
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        return "student/list"; // Giả sử bạn có một view students/list.jsp
    }

    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable Integer id, Model model) {
        // Trả về tên view để hiển thị form chỉnh sửa sinh viên
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/edit"; // Giả sử bạn có một view students/edit.jsp
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Student student) {
        // Cập nhật thông tin sinh viên
        studentService.updateStudent(student);
        return "redirect:/students"; // Chuyển hướng về danh sách sinh viên sau khi cập nhật
    }
    @GetMapping("/add")
    public String showAddStudentForm() {
        // Trả về tên view để hiển thị form thêm sinh viên
        return "student/add"; // Giả sử bạn có một view students/add.jsp
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students"; // Chuyển hướng về danh sách sinh viên sau khi thêm
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        // Xóa sinh viên theo ID
        studentService.deleteStudent(id);
        return "redirect:/students"; // Chuyển hướng về danh sách sinh viên sau khi xóa
    }
    @GetMapping("/init")
    public String initStudentData() {
        // Phương thức này có thể được sử dụng để khởi tạo dữ liệu mẫu
        // Ví dụ: thêm một số sinh viên vào cơ sở dữ liệu
        studentService.initData();
        return "redirect:/students"; // Chuyển hướng về danh sách sinh viên sau khi khởi tạo
    }
}
