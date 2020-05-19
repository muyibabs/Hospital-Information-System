package com.muyi.hrservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muyi.hrservice.models.Employee;
import com.muyi.hrservice.models.EmployeesList;


@RestController
@RequestMapping("/hr")
public class HrResource {
	List<Employee> employees = Arrays.asList(
		new Employee("E1","Ashley", "Way", "Surgery"),
		new Employee("E2","Aboba", "Omalicha", "Dentistry"),
		new Employee("E3","Andrew", "Komodo", "Optical"),
		new Employee("E4","Steve", "Habor","MediTech")
	);
	
	@GetMapping("/employees")
	public EmployeesList getEmployees(){
		EmployeesList empList = new EmployeesList();
		empList.setEmployees(employees);
		return empList;
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id) {
		Employee em = employees.stream()
				.filter(e -> e.getId().equals(id)).findAny()
				.orElse(null);
		return em;
	}
}
