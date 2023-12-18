package com.springboot.revision;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ProductController {

	
	@RequestMapping("/test")
	
	public String run()
	{
		return "My name is prince kumar";
	}
	
	
	/*
	 * JPA(JAVA PERSISTENCE API)
	 * ======================================================================
	 * Jpa is defined as that it is an orm tool(object relational mapping) tool.
	 * 
	 * here we use orm as a third party application so that it accept the object from java and stores it into the databse.
	 * 
	 * 
	 * like as we want to store some data to the database can say information of employee then we have to create object of employee that obhect get by orm and that objetc get sstored into 
	 * database all the sql operation gets perform by hibernate automatically.if we do nt use orm in the middle then we have to write query languga eto store the data into databse.
	 * 
	 * so what object we have to store like the objetc of Pojo classes we have to store into databs e as the objetc of pojo gets created the objetc gets stored into particulkar row of 
	 * database table.
	 * 
	 * so how orm perform all thesre things so here ewe hae toperform mappig like the d data goes to id column only and all so these all mapping w ehav eto perform in application.properties.
	 * 
	 * 
	 * 
	 * jpa(java persistence api)
	 * 
	 * =========================================================================
	 * Jpa it is actually an specification it does not an implementation like orcal provide standars or can ay steps in the form of jpa but the actual implementationis hibernate 
	 * like in jdbc jdbc is an specification but the implemenations ar ejdbc driver.
	 * 
	 * so we can say that jpa specifies but hibernate implementa 
	 * 
	 * so jpa provide us two interfaces like :--
	 * 1) Entity manager factory 
	 * 2) entity manager
	 * 
	 * so we can say that this entity manager factor if provides the objet of entity manager and actyally this entiuty magare it contains all the method of crud operation i.eto dleet eto updat eto read to create and all.
	 * 
	 * 
	 * 
	 * 
	 */
}
