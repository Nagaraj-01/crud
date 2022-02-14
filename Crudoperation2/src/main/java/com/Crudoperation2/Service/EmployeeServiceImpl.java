package com.Crudoperation2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Crudoperation2.Model.Employee;
import com.Crudoperation2.Repository.EmployeeRepository;


import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEpmloyees() {
		return employeeRepository.findAll();
	}
	

	@Override
	public Employee getEmployeeById(long id) {
		java.util.Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}
	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepository.save(employee);
	}


	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}
	

}
