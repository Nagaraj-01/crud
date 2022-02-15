package com.assignment1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment1.Entity.Student;
import com.assignment1.Repository.StudentRepository;
@Service
public class StudentSerrviceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Long saveStudent(Student student) {
		return (long) studentRepository.save(student).getSLno();
	}

	@Override
	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long SLno) {
		return studentRepository.findById(SLno).get();
	}

	@Override
	public void deleteStudent(Long SLno) {
		studentRepository.deleteById(SLno);
		
	}

}
