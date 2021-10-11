package com.psl.user.service;

import com.psl.user.entity.User;
import com.psl.user.valueobject.ResponseTemplate;

public interface UserService {

	User saveUser(User user);

	ResponseTemplate getUserWithDepartment(Long userId);
}
