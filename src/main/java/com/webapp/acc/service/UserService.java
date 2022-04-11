package com.webapp.acc.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.webapp.acc.entity.User;
import com.webapp.acc.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{

	User save (UserRegistrationDto registrationDto);
}
