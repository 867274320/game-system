package org.evolution.gamesystem.user;

import org.evolution.BaseTest;
import org.evolution.modules.user.entities.User;
import org.evolution.modules.user.mapper.UserMapper;
import org.evolution.util.IdWorker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void selectById() {
        User param = new User();
        param.setUsername("admin");
        param.setPassword("123456");
        User user = userMapper.selectOne(param);
        System.out.println(user);
    }


    @Test
    public void insert() {
        IdWorker worker = new IdWorker(1,1,1);
        User param = new User();
        param.setRowId(worker.nextId());
        param.setUsername("admin");
        param.setPassword("123456");
        userMapper.insertAllColumn(param);
    }
}
