package com.greatLearning.studentManagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.greatLearning.studentManagement.entity.Student;

public class StudentServiceImpl implements StudentService {


	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}


	}
	
	@Override
	@Transactional
	public List<Student> getAllStudents() {
		Transaction tx = session.beginTransaction();

		List<Student> students=session.createQuery("from Student").list();

		tx.commit();

		return students;
	}

	@Override
	public Student getStudentByID(int id) {
		Student student = new Student();

		Transaction tx = session.beginTransaction();

		student = session.get(Student.class, id);

		tx.commit();

		return student;
	}

	@Override
	public void addStudent(Student stud) {
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(stud);

		tx.commit();		
	}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
		Transaction tx = session.beginTransaction();

		Student student = session.get(Student.class, id);

		session.delete(student);

		tx.commit();
	}

}
