package com.coditas.SpringBatchDemo.Repository;

import com.coditas.SpringBatchDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    @Modifying
    @Query("update User u set u.sal=:sal where name=:name")
    void updateSal(@Param("sal")Integer sal,@Param("name")String name);

}
