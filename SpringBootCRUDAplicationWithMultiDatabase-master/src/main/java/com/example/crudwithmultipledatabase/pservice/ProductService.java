package com.example.crudwithmultipledatabase.pservice;

import com.example.crudwithmultipledatabase.postgres.Product;
import com.example.crudwithmultipledatabase.postgres.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String upsert2(Product product){
        productRepository.save(product);
        return "data has saved in product table ";
    }

    public  Product getByID(Integer id){
        Optional<Product> data=productRepository.findById(id);

        if(data.isPresent())return data.get();

        return null;

    }

    public String DeleteByID(Integer id){
        productRepository.deleteById(id);
        return "data has deleted";
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

}
