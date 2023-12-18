package com.example.crudwithmultipledatabase.mysql;


import lombok.Data;

import jakarta.persistence.*;


@Data
@Entity
@Table(name = "mysqlMultiple")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
       private Integer id;

      private String firstname;
      private String lastName;
      private String email;

}
