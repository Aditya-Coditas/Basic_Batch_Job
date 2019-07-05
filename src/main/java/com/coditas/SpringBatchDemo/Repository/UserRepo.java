package com.coditas.SpringBatchDemo.Repository;

import com.coditas.SpringBatchDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
