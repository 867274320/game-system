package org.evolution.modules.user.service.impl;

import org.evolution.modules.user.entities.User;
import org.evolution.modules.user.mapper.UserMapper;
import org.evolution.modules.user.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tanglijie
 * @since 2022-12-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    public User login(User entity) throws Exception {
        User user = userMapper.selectOne(entity);
        return user;
    }
}
