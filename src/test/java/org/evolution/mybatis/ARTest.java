package org.evolution.mybatis;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.evolution.GameSystemApplication;
import org.evolution.modules.website.entities.Website;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = GameSystemApplication.class)
public class ARTest {

    /**
     * AR  分页复杂操作
     */
    @Test
    public void  testARPage() {

        Website Website = new Website();

        Page<Website> page = Website.selectPage(new Page<>(1, 1),
                new EntityWrapper<Website>().like("last_name", "老"));
        List<Website> emps = page.getRecords();
        System.out.println(emps);
    }


    /**
     * AR 删除操作
     *
     * 注意: 删除不存在的数据 逻辑上也是属于成功的.
     */
    @Test
    public void testARDelete() {

        Website Website = new Website();
        //boolean result = Website.deleteById(2);
//		Website.setId(2);
//		boolean result = Website.deleteById();
//		System.out.println("result:" +result );


        boolean result = Website.delete(new EntityWrapper<Website>().like("last_name", "小"));
        System.out.println(result );
    }


    /**
     * AR 查询操作
     */
    @Test
    public void testARSelect() {
        Website Website = new Website();

        //Website result = Website.selectById(14);
//		Website.setId(14);
//		Website result = Website.selectById();
//		System.out.println(result );


//		List<Website> emps = Website.selectAll();
//		System.out.println(emps);

//		List<Website > emps=
//				Website.selectList(new EntityWrapper<Website>().like("last_name", "老师"));
//		System.out.println(emps);

        Integer result = Website.selectCount(new EntityWrapper<Website>().eq("gender", 0));
        System.out.println("result: " +result );



    }


    /**
     * AR 修改操作
     */
    @Test
    public void testARUpdate() {
        Website Website = new Website();
/*        Website.setId(20);
        Website.setLastName("宋老湿");
        Website.setEmail("sls@atguigu.com");
        Website.setGender(1);
        Website.setAge(36);*/


        boolean result = Website.updateById();
        System.out.println("result:" +result );

    }



    /**
     * AR  插入操作
     */
    @Test
    public void  testARInsert() {
        Website Website = new Website();
//        Website.setLastName("宋老师");
//        Website.setEmail("sls@atguigu.com");
//        Website.setGender(1);
//        Website.setAge(35);

        boolean result = Website.insert();
        System.out.println("result:" +result );
    }
}
