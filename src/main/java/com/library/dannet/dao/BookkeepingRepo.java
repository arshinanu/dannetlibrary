package com.library.dannet.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.dannet.pojo.Bookkeeping;

@Repository
@Transactional
public interface BookkeepingRepo extends JpaRepository<Bookkeeping, Integer> {
	
	@Modifying
	@Query("update Bookkeeping  set availablecopies = :availablecopies , bookedcopies = :bookedcopies where bookid=:bookid")
	public int updateBookkeeping(int bookid,int availablecopies,int bookedcopies);

}
