package com.luxcampus.dao;

import com.luxcampus.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> getAllStudents();

    public void saveStudent(Student student);

    public Student getStudent(int id);

    void deleteStudent(int id);
}
