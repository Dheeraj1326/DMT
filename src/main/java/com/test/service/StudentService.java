package com.test.service;

import java.util.List;

import com.test.model.Student;

public interface StudentService {
	public List<Student> studentList();
	public Student addStudent(Student student);
	public Student findStudentById(int id);
	public Student updateStudent(Student student, int id);
	public Student deleteStudent(int id);
	public Student findStudentByEmailAndPassword(String email, String password);
}
