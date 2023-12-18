package com.springboot.JPQL;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.JPQL.Entities.Product;
import com.springboot.JPQL.Repository.ProductRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
     ApplicationContext context=SpringApplication.run(Application.class, args);
     ProductRepository repository= context.getBean(ProductRepository.class);
     
//     Product product=new Product();
//     
//     System.out.println("Enter the name of the product :");
//     String name=sc.nextLine();
//     product.setName(name);
//     
//     System.out.println("Enter the quantity of the product :");
//     int quantity=sc.nextInt();
//     product.setQuantity(quantity);
//     
//     System.out.println("Enter the price of the product :");
//     double price=sc.nextDouble();
//     product.setPrice(price);
//     
//     repository.save(product);
//     System.out.println("Your data gets stored in the memory ");
     
     // we want to get the elemenst from the table by using jpol
     
//     System.out.println("Enter the name of the product :");
//     String name=sc.nextLine();
//     List<Product> pro=repository.getByName(name);
     
//     pro.forEach(de->System.out.println(de));
     
//     System.out.println("Enter the character by which you want details :");
//     String ch=sc.nextLine();
//     List<Product> li=repository.getByNamestart(ch);
//     li.forEach(po->System.out.println(po));
     
     // i have to use the sql native language.
     
//     List<Product> l1= repository.getByPriceLess();
//     l1.forEach(lu->System.out.println(lu));
     
     System.out.println("Enter the quantity :");
     int quantity=sc.nextInt();
     List<Product> p1= repository.productbypricelessthan(quantity);
     
     p1.forEach(p2->System.out.println(p2));
     
     
     
	}

}
