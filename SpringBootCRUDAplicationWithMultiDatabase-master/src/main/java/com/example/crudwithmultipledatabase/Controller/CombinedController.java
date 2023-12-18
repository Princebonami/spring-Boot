package com.example.crudwithmultipledatabase.Controller;


import com.example.crudwithmultipledatabase.mysql.User;
import com.example.crudwithmultipledatabase.postgres.Product;
import com.example.crudwithmultipledatabase.pservice.ProductService;
import com.example.crudwithmultipledatabase.uservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.Optional;

@RestController
@RequestMapping("/data")
public class CombinedController {

//    @Autowired
//    private ProductService productService;
//    @Autowired
//    private UserService userService;


    @PostMapping("/data")
    ResponseEntity<String>  creating(@RequestBody DataWrapper dataWrapper){
        User user=dataWrapper.getUser_data();
        Product product=dataWrapper.getProduct_data();

        String status=userService.upsert(user);
        String status2=productService.upsert2(product);

        return new ResponseEntity<>("data has inserted", HttpStatus.OK);
    }
    private final UserService userService;
    private final ProductService productService;


    @Autowired
    CombinedController(UserService userService,ProductService productService){
        this.userService=userService;
        this.productService=productService;
    }

    @GetMapping("/{id}")
    ResponseEntity<DataWrapper> fetchingDataByID(@PathVariable Integer id){
           Optional<User> data= Optional.ofNullable(userService.getByID(id));
           Optional<Product> data1= Optional.ofNullable(productService.getByID(id));

        if(data1.isPresent() && data.isPresent()){
            DataWrapper dataWrapper=new DataWrapper();
            dataWrapper.setProduct_data(data1.get());
            dataWrapper.setUser_data(data.get());

            return new ResponseEntity<>(dataWrapper,HttpStatus.OK);
        }


        return null;
    }



}
