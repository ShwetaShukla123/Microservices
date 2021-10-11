package com.psl.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.psl.user.entity.User;
import com.psl.user.repository.UserRepository;
import com.psl.user.valueobject.Department;
import com.psl.user.valueobject.ResponseTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User saveUser(User user) {
		log.info("inside save method of user service");
		return userRepository.save(user);
	}

	@Override
	@CircuitBreaker(name="example", fallbackMethod = "fallback")
	public ResponseTemplate getUserWithDepartment(Long userId) {
		log.info("inside getUserWithDepartment method of user service");
		ResponseTemplate responseTemplate = new ResponseTemplate();
		User user = userRepository.findById(userId).get();
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDeptId(), Department.class);
		responseTemplate.setUser(user);
		responseTemplate.setDepartment(department);
		return responseTemplate;
	}
	
	public ResponseTemplate fallback(Exception ex) {
		ResponseTemplate responseTemplate = new ResponseTemplate();
		User user = new User();
		user.setFirstName("xyz");
		user.setLastName("wxy");
		user.setEmail("x@gmail.com");
		user.setDeptId("1");
		user.setUserId(1L);
		Department dept = new Department();
		dept.setDeptAddress("abc");
		dept.setDeptCode("121");
		dept.setDeptName("NA");
		dept.setDeptId(1L);
		responseTemplate.setDepartment(dept);
		responseTemplate.setUser(user);
		return responseTemplate;
	}

}
