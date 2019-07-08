package com.coditas.SpringBatchDemo.batch;

import com.coditas.SpringBatchDemo.Repository.UserRepo;
import com.coditas.SpringBatchDemo.model.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Writer implements ItemWriter<User> {
    public List<User> unique=new ArrayList<>();


    @Autowired
    UserRepo repo;
    @Override
    public void write(List<? extends User> users) throws Exception {
        for(User u:users) {
            if(isUnique(u)) {
                  repo.save(u);
              }
              else
              {
                repo.updateSal(u.getSal(),u.getName());
              }
          }
    }

    public boolean isUnique(User user)
    {
        if(unique.size()==0)
        {
            unique.add(user);
            return true;
        }
        else
        {
            for(User us:unique)
            {
                if(us.getName().equals(user.getName()))
                {

                    return false;
                }
            }
            unique.add(user);
            return true;
        }
    }
}
