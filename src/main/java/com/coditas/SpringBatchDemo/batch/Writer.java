package com.coditas.SpringBatchDemo.batch;

import com.coditas.SpringBatchDemo.Repository.UserRepo;
import com.coditas.SpringBatchDemo.model.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer implements ItemWriter<User> {
    @Autowired
    UserRepo repo;
    @Override
    public void write(List<? extends User> users) throws Exception {
        for(User u:users) {
              System.out.println(u);
              repo.save(u);
          }
    }
}
