package com.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Student;
import com.test.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepo;
	
	@Override
	public List<Student> studentList() {
		// TODO Auto-generated method stub
		return studentRepo.findStudentByStatus(1);
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		student.setCreated(new Date());
		student.setModified(new Date());
		student.setStatus(1);
		
		return studentRepo.save(student);
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		List<Student> studentList = studentList();
		Student s = null;
		for(Student std : studentList) {
			if(std.getId() == id) {
				s = std;
			}
		}
		return s;
	}

	@Override
	public Student updateStudent(Student student, int id) {
		// TODO Auto-generated method stub
		Student oldS = findStudentById(id);
		
		oldS.setName(student.getName());
		oldS.setAddress(student.getAddress());
		oldS.setPassword(student.getPassword());
		oldS.setDob(student.getDob());
		oldS.setEmail(student.getEmail());
		oldS.setModified(new Date());
		
		Student save = studentRepo.save(oldS);
		
		return save;
	}

	@Override
	public Student deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student findStudentById = findStudentById(id);
		findStudentById.setStatus(0);
		Student save = studentRepo.save(findStudentById);
		return save;
	}

	@Override
	public Student findStudentByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return studentRepo.findStudentByEmailAndPassword(email, password);
	}

}
