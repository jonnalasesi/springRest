package com.howtodoinjava.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.EmployeeListVO;
import com.howtodoinjava.demo.model.EmployeeVO;

@RestController
public class EmployeeRESTController {
	@RequestMapping(value = "/employees")
	public @ResponseBody EmployeeListVO getAllEmployees() {
		EmployeeListVO employees = new EmployeeListVO();

		EmployeeVO empOne = new EmployeeVO(1, "sesiKumar", "Jonnala", "jonnala.java@gmail.com");
		EmployeeVO empTwo = new EmployeeVO(2, "Kumar", "Jonnala", "jonnala@yahoo.com");
		EmployeeVO empThree = new EmployeeVO(3, "sesi", "Jonnala", "sesiJonnala@gmail.com");

		employees.getEmployees().add(empOne);
		employees.getEmployees().add(empTwo);
		employees.getEmployees().add(empThree);

		return employees;
	}

	@RequestMapping(value = "/employees/{id}")
	@ResponseBody
	public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable("id") int id) {
		if (id <= 3) {
			if (id == 1) {

				EmployeeVO empOne = new EmployeeVO(1, "sesiKumar", "Jonnala", "jonnala.java@gmail.com");
				return new ResponseEntity<EmployeeVO>(empOne, HttpStatus.OK);
			}
			if (id == 2) {

				EmployeeVO empTwo = new EmployeeVO(2, "Kumar", "Jonnala", "jonnala@yahoo.com");
				return new ResponseEntity<EmployeeVO>(empTwo, HttpStatus.OK);
			}
			if (id == 3) {

				EmployeeVO empThree = new EmployeeVO(3, "sesi", "Jonnala", "sesiJonnala@gmail.com");
				return new ResponseEntity<EmployeeVO>(empThree, HttpStatus.OK);
			}
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}