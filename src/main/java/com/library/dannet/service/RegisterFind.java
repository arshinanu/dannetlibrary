package com.library.dannet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dannet.dao.RegistrationRepo;
import com.library.dannet.pojo.Registration;

@Service
public class RegisterFind implements Registerservice {

	
	@Autowired
	RegistrationRepo repo;

	@Override
	public Registration find(Registration registration) {
		
		return repo.getRegistration(registration.getAadharid(), registration.getPassword());
	}
	
	
	
	
	
}
