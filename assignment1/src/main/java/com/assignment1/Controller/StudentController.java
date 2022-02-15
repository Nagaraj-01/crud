package com.assignment1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment1.Entity.Student;
import com.assignment1.Service.StudentService;

@RestController
@RequestMapping("/studentDetails")

public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		
		Long id=service.saveStudent(student);
		return new ResponseEntity<String>("student with"+id+"has been saved",HttpStatus.OK);
	}
	@GetMapping("/studentList")
	public ResponseEntity<List<Student>> getallStudentdetails(){
		List<Student> list =service.getAllStudent();
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	@GetMapping("/studentList/{SLno}")
	public ResponseEntity<Student> getstudetById(@ PathVariable("SLno") Long SLno){
		Student std = service.getStudentById(SLno);
		return new ResponseEntity<Student>(std,HttpStatus.OK);
		
	}
	@PutMapping("/updateStudent/{Slno}")
	public ResponseEntity<String> updateStudent( @PathVariable("Slno") Long SLno, @RequestBody Student student){
		Student stdfromDB =service.getStudentById(SLno);
		stdfromDB.setStudent_Name(student.getStudent_Name());
		stdfromDB.setStudent_Class(student.getStudent_Class());
		stdfromDB.setSchool_Name(student.getSchool_Name()); 
		service.saveStudent(stdfromDB);
		return new ResponseEntity<String>("student with'"+SLno+"has been deleted",HttpStatus.OK);
	}
	@DeleteMapping("/deleteStudent/{SLno}")
	public ResponseEntity<String> deleteStudent(@PathVariable("SLno") long SLno){
		service.deleteStudent(SLno);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
