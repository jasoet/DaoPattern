package id.ac.uad.plankton.dao;

import id.ac.uad.plankton.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * [TODO: Documentation]
 *
 * @author Deny Prasetyo.
 */

public interface StudentDao {

    void insert(Student student) throws SQLException;

    void update(int id, Student updatedStudent) throws SQLException;

    void delete(int id) throws SQLException;

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByNameLike(String name);

}
