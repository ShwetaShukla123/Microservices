package com.psl.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.department.entity.Department;
import com.psl.department.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DeptController {

	@Autowired
	DeptService deptService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department dept) {
		log.info("inside saveDepartment method of deptController");
		return deptService.saveDepartment(dept);
	}
	
	@GetMapping("/{id}")
	public Department getDeptById(@PathVariable("id") Long id) {
		log.info("inside getDeptById method of deptController");
		return deptService.findDeptById(id);
	}
}
