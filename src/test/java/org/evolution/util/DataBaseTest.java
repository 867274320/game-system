//package org.evolution.util;
//
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.plugins.Page;
//import org.apache.ibatis.session.Configuration;
//import org.evolution.GameSystemApplication;
//import org.evolution.modules.user.entities.User;
//import org.evolution.modules.user.mapper.UserMapper;
//import org.evolution.modules.website.entities.Website;
//import org.evolution.modules.website.mapper.WebsiteMapper;
//import org.evolution.modules.website.service.WebsiteService;
//import org.evolution.modules.website.service.impl.WebsiteServiceImpl;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes = GameSystemApplication.class)
//public class DataBaseTest {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private WebsiteServiceImpl websiteService;
//
//
//    @Autowired
//    private WebsiteMapper websiteMapper;
//
//
//
//
//    /*
//    * 启动的时候注入了sql语句
//    *   MapperProxy
//    *   SqlAutoInjector
//    *
//    * */
//
//
//    /*自定义全局操作*/
//
//    /*
//    * Configuration配置体系
//    * properties
//    * setting
//    * typeAliases
//    * typeHandlers
//    * environments
//    * mappers
//    *
//    * */
//    public static void main(String[] args) {
//        Configuration configuration = new Configuration();
//    }
//
//    /*测试mybatis*/
//    @Test
//    public void testMybatis() throws Exception{
//        User user = userMapper.selectById(1L);
//        System.out.println(user);
//
//    }
//
//    /*测试数据库连接*/
//    @Test
//    public void testConnection() throws Exception{
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//    }
//}
