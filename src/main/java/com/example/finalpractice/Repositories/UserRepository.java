package com.example.finalpractice.Repositories;

import com.example.finalpractice.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {


//
//    List<Users> FindByName(String name);


}
