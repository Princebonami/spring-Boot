package com.example.crudwithmultipledatabase.uservice;

import com.example.crudwithmultipledatabase.mysql.User;
import com.example.crudwithmultipledatabase.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    protected UserRepository userRepository;

   public String upsert(User user){
        userRepository.save(user);
        return "data has created";
    }

   public User getByID(Integer id){
       Optional<User> data=userRepository.findById(id);
       if(data.isPresent()) {
           return data.get();
       }

       return null;
   }

   public List<User> getAll (){
        return userRepository.findAll();
   }

  public String DeleteByID(Integer id)
  {
      userRepository.deleteById(id);
      return "data has Deleted";
  }
}
