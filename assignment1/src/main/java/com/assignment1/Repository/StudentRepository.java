package com.assignment1.Repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment1.Entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
