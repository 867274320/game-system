package org.evolution.modules.user.service;

import org.evolution.modules.user.entities.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tanglijie
 * @since 2022-12-06
 */
public interface UserService extends IService<User> {

    /*登录*/
    public User login(User entity) throws Exception;

}
