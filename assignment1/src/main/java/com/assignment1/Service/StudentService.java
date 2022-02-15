package com.assignment1.Service;

import java.util.List;

import com.assignment1.Entity.Student;

public interface StudentService {
	public Long saveStudent(Student student);
	
	public List<Student> getAllStudent();
	public Student getStudentById(Long SLno);
	
	public void deleteStudent(Long SLno);

}
