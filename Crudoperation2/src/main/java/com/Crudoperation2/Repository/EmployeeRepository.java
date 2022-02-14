package com.Crudoperation2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Crudoperation2.Model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
