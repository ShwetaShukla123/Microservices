package com.psl.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psl.department.entity.Department;

@Repository
public interface DeptRepository extends JpaRepository<Department, Long> {

}
