package ra.orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.orm.dao.StudentDaoImpl;
import ra.orm.entity.Student;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentDaoImpl studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudent();
    }


    @Override
    public void addStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
     studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
       studentDao.deleteStudent(id);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void initData() {
        Student s1 = new Student(null,"Nguyen Van A", "a@gmail.com", "0123456789", "Hanoi", LocalDate.of(2000, 1, 1));
        Student s2 = new Student(null,"Nguyen Van B", "b@gmail.com" , "0987654321", "Hanoi", LocalDate.of(2001, 2, 2));
        studentDao.insertStudent(s1);
        studentDao.insertStudent(s2);
    }
}
