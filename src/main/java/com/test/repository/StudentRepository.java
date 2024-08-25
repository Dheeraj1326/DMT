package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	public Student findStudentByEmailAndPassword(String email, String password);
	
	public List<Student> findStudentByStatus(int status);
}
