package com.library.dannet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.dannet.pojo.Orders;

@Repository
@Transactional
public interface OrderRepo extends JpaRepository<Orders, Integer> {
	
	
	@Query("from Orders where aadharid=:aadharid and status='ACTIVE'")
	public List<Orders> getOrders(String aadharid);
	
	@Modifying
	@Query("update Orders  set status ='INACTIVE' where orderid=:ord ")
	public int updateOrders(int ord);
	
	@Query("from Orders where status='ACTIVE'")
	public List<Orders> getAvailOrders();
	
	@Query("select count(*) from Orders where aadharid=:aadharid and status='ACTIVE' and bookid=:bookid")
	public int getbookOrder(String aadharid,int bookid);
	

}
