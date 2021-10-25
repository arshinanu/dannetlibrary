package com.library.dannet.dao;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.dannet.pojo.Duestatus;

public interface Duestatusrepo extends JpaRepository<Duestatus, Date> {
	
	@Query(" from Duestatus where currentdate=:duedate")
	public Duestatus getDuestatus(Date duedate);

}
