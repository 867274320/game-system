package org.evolution.modules.user.controller;


import com.baomidou.mybatisplus.mapper.Condition;
import org.evolution.modules.user.entities.Info;
import org.evolution.modules.user.entities.User;
import org.evolution.modules.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tanglijie
 * @since 2022-12-06
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "/login")
    public HashMap<String,Object> login(@RequestBody User entity) {
        HashMap hashMap = new HashMap();
        try {
            User user = userService.login(entity);
            user.setToken("admin-token");
            hashMap.put("code",200);
            hashMap.put("success","true");
            hashMap.put("data",user);
        } catch (Exception e) {
            hashMap.put("success","false");
            hashMap.put("data",e.getMessage());
        }
        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/info")
    public HashMap<String,Object> info() {
        HashMap hashMap = new HashMap();
        try {
            Info info = new Info();
            String[] arrayList = new String[]{"admin"};
            info.setRoles(arrayList);
            info.setName("Super Admin");
            info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            info.setIntroduction("I am a super administrator");
            hashMap.put("code",200);
            hashMap.put("success","true");
            hashMap.put("data",info);
        } catch (Exception e) {
            hashMap.put("success","false");
            hashMap.put("code",200);
            hashMap.put("data",e.getMessage());
        }
        return hashMap;
    }
}

