package com.example.crudwithmultipledatabase.mysql;

import com.example.crudwithmultipledatabase.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


}
