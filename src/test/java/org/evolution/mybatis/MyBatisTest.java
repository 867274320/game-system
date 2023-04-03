package org.evolution.mybatis;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.evolution.GameSystemApplication;
import org.evolution.modules.website.entities.Website;
import org.evolution.modules.website.mapper.WebsiteMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = GameSystemApplication.class)
public class MyBatisTest {

    @Autowired
    private WebsiteMapper websiteMapper;

    /*mybatis插件机制*/
    public void testMybatisPlugin() throws Exception{
        /*
         Executor
         StatementHandler
         ParameterHandler
         ResultSetHandler
         */
    }

    /*测试mybatis*/
    @Test
    public void testWebsiteService() throws Exception{
        List<Website> websites = websiteMapper.selectPage(new Page<>(1,2),
                /**/
                new EntityWrapper<Website>());
        System.out.println(websites);



//        System.out.println(websiteMapper.deleteAll());

    }
}
