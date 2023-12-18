package com.example.crudwithmultipledatabase.Controller;

import com.example.crudwithmultipledatabase.mysql.User;
import com.example.crudwithmultipledatabase.postgres.Product;
import lombok.Data;

@Data
public class DataWrapper {

    private User user_data;
    private Product product_data;

    
}
