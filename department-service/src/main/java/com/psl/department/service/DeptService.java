package com.psl.department.service;

import com.psl.department.entity.Department;

public interface DeptService {

	Department saveDepartment(Department dept);
	
	public Department findDeptById(Long id);

}
