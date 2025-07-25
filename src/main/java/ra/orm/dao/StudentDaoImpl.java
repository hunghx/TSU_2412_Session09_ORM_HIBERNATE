package ra.orm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.orm.entity.Student;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl {
    @Autowired
    private SessionFactory sessionFactory;
  // nhóm  chúc năng truy xuất dữ liệu từ cơ sở dữ liệu
    //  HQL
    // lấy về danh sach sv
    public List<Student> getAllStudent(){
        Session session = sessionFactory.openSession();
        TypedQuery<Student> query = session.createQuery("SELECT S FROM Student S",Student.class);
        List<Student> studentList = query.getResultList();
        session.close();
        return studentList;
    }
    public Student getStudentById(Integer id){
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
    // nhóm cập nhật dữ liệu
    // Phưong  thức  đưược đinh nghĩa sẵn
    public void insertStudent(Student student){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(student); // lưu đối tượng Student vào cơ sở dữ liệu
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Ném lại ngoại lệ để xử lý ở nơi khác nếu cần
        } finally {
            session.close();
        }
    }
    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(student); // cập nhật đối tượng Student trong cơ sở dữ liệu
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Ném lại ngoại lệ để xử lý ở nơi khác nếu cần
        } finally {
            session.close();
        }
    }
    public void deleteStudent(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student); // xóa đối tượng Student khỏi cơ sở dữ liệu
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Ném lại ngoại lệ để xử lý ở nơi khác nếu cần
        } finally {
            session.close();
        }
    }
}
