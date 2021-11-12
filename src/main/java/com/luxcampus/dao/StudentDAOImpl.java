package com.luxcampus.dao;

import com.luxcampus.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> allStudents =
                session.createQuery("from Student", Student.class)
                        .getResultList();
        return allStudents;
    }

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(student);//if id = 0 =>save, if id !=0 =>update
    }

    @Override
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id); //get student from database per id
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query =
                session.createQuery("delete from Student " +
                        "where id=:studentId");//instead studentId => param id
        query.setParameter("studentId", id);
        query.executeUpdate();
    }
}