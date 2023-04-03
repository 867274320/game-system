package org.evolution.mybatis;

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
public class PluginTest {

    @Autowired
    private WebsiteMapper websiteMapper;

    /**
     * 测试 乐观锁插件
     */

    @Test
    public void testOptimisticLocker() {
        //更新操作
        Website website = new Website();
//        Website.setId(15);
//        Website.setLastName("TomAA");
//        Website.setEmail("tomAA@sina.com");
//        Website.setGender("1");
//        Website.setAge(22);
//        Website.setVersion(3);

        websiteMapper.updateById(website);

    }

    /**
     * 测试 性能分析插件
     */
    @Test
    public void testPerformance() {
        Website website = new Website();
//        Website.setLastName("玛利亚老师");
//        Website.setEmail("mly@sina.com");
//        Website.setGender("0");
//        Website.setAge(22);

        websiteMapper.insert(website);

    }

    /**
     * 测试SQL执行分析插件
     */
    @Test
    public void testSQLExplain() {

        websiteMapper.delete(null);  // 全表删除
    }

    /**
     * 测试分页插件
     */
    @Test
    public void testPage() {

        Page<Website> page = new Page<>(1,1);

        List<Website > emps =
                websiteMapper.selectPage(page, null);
        System.out.println(emps);


        System.out.println("===============获取分页相关的一些信息======================");

        System.out.println("总条数:" +page.getTotal());
        System.out.println("当前页码: "+  page.getCurrent());
        System.out.println("总页码:" + page.getPages());
        System.out.println("每页显示的条数:" + page.getSize());
        System.out.println("是否有上一页: " + page.hasPrevious());
        System.out.println("是否有下一页: " + page.hasNext());

        //将查询的结果封装到page对象中
        page.setRecords(emps);


    }
}
