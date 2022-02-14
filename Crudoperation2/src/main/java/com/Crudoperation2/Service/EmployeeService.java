package com.Crudoperation2.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Crudoperation2.Model.Employee;

public interface EmployeeService {

	List<Employee> getAllEpmloyees();
		void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
