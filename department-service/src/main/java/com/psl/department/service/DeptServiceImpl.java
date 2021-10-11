package com.psl.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.department.entity.Department;
import com.psl.department.repository.DeptRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	DeptRepository deptRepository;

	@Override
	public Department saveDepartment(Department dept) {
		log.info("inside saveDepartment method of DeptServiceImpl");
		return deptRepository.save(dept);
	}
	
	@Override
	public Department findDeptById(Long id) {
		log.info("inside findDeptById method of DeptServiceImpl");
		return deptRepository.findById(id).get();
	}

}
