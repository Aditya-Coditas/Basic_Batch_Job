package com.coditas.SpringBatchDemo.batch;

import com.coditas.SpringBatchDemo.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<User,User> {

    @Override
    public User process(User user) throws Exception {
         int sal=user.getSal()+1000;
         user.setSal(sal);
         System.out.println("User Sal is Processed  "+user);
        return user;
    }
}
