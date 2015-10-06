package id.ac.uad.plankton;

import id.ac.uad.plankton.dao.StudentDao;
import id.ac.uad.plankton.dao.impl.StudentDaoImpl;
import id.ac.uad.plankton.db.DatabaseConnection;
import id.ac.uad.plankton.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * [TODO: Documentation]
 *
 * @author Deny Prasetyo.
 */

public class MainApplication {
    public static void main(String[] args) {

        Student kipli = new Student(1, "Bayu Zuklifly", "Seturan");
        Student deny = new Student(2, "Deny Prasetyo", "Kotagede");
        Student avii = new Student(3, "Altaira Naviid", "Kotagede");

        Student jamal = Student.of(4, "Jamaludin", "Mbuh nang ndhi");

        try {
            StudentDao studentDao = new StudentDaoImpl(DatabaseConnection.getInstance().getConnection());
            studentDao.insert(kipli);
            studentDao.insert(deny);

            List<Student> studentList = studentDao.findAll();

            for (Student s : studentList) {
                System.out.println(s.getName());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
