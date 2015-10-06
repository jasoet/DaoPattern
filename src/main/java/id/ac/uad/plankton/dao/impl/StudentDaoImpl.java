package id.ac.uad.plankton.dao.impl;

import id.ac.uad.plankton.dao.StudentDao;
import id.ac.uad.plankton.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * [TODO: Documentation]
 *
 * @author Deny Prasetyo.
 */

public class StudentDaoImpl implements StudentDao {

    private final Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Student student) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (name,address) VALUES (?,?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getAddress());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(int id, Student updatedStudent) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET name=?,address=? WHERE id=?");
        preparedStatement.setString(1, updatedStudent.getName());
        preparedStatement.setString(2, updatedStudent.getAddress());
        preparedStatement.setInt(3, updatedStudent.getId());

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,name,address AS alamat FROM student");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAddress(resultSet.getString("alamat"));

                studentList.add(student);
            }

            return studentList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Student> findByNameLike(String name) {
        return null;
    }
}
