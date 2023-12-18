package com.springboot.JPQL.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.JPQL.Entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
	
//	@Query("select u from Product u where u.name=:n")
//	public List<Product> getByName(@Param("n") String name);
	
//	@Query("select u from Product u where u.name like :n%")
//	public List<Product> getByNamestart(@Param("n") String n);
	
	
//	@Query(value = "select * from product " ,nativeQuery=true)
//	public List<Product> getByPriceLess();
	
	@Query(value = "select * from product where quantity <= :n" , nativeQuery = true)
	public List<Product> productbypricelessthan(@Param("n") int quantity);
	
//	@Query(value = " ")
//	public List<Product> getAllData();
}
