package com.greatLearning.studentManagement.service;

import java.util.List;

import com.greatLearning.studentManagement.entity.Student;

public interface StudentService {

	public List<Student> getAllStudents();

	public Student getStudentByID(int id);

	public void addStudent(Student stud);

	public void deleteStudentById(int id);

}
