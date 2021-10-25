package com.library.dannet.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.dannet.pojo.Registration;

@Repository
@Transactional
public interface RegistrationRepo extends JpaRepository<Registration, String> {
	
	@Query("from Registration where aadharid=:aadharid and password=:password")
	public Registration getRegistration(String aadharid,String password); 
	
	
	@Query("from Registration where aadharid=:aadharid")
	public Registration getRegistrations(String aadharid); 

}
