package com.library.dannet.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.dannet.dao.Duestatusrepo;
import com.library.dannet.pojo.Duestatus;

public class Dueserricecheckerimp implements Duesericechecker {

	
	@Autowired
	Duestatusrepo dsr;
	
	@Override
	public Duestatus find(Duestatus dss) {
		Duestatus dss1=dsr.getDuestatus(dss.getCurrentdate());
		return dss1;
	}

}
