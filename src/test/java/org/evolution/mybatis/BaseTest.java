package org.evolution.mybatis;

import com.baomidou.mybatisplus.mapper.Condition;
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
public class BaseTest {

    @Autowired
    private WebsiteMapper websiteMapper;

    /**
     * 条件构造器  删除操作
     */
    @Test
    public void testEntityWrapperDelete() {

        websiteMapper.delete(
                new EntityWrapper<Website>()
                        .eq("last_name", "Tom")
                        .eq("age", 22)
        );
    }


    /**
     * 条件构造器  修改操作
     */
    @Test
    public void testEntityWrapperUpdate() {

        Website Website = new Website();
//        Website.setLastName("苍老师");
//        Website.setEmail("cls@sina.com");
//        Website.setGender(0);


        websiteMapper.update(Website,
                new EntityWrapper<Website>()
                        .eq("last_name", "Tom")
                        .eq("age", 44)
        );
    }

    /**
     * 条件构造器   查询操作
     */
    @Test
    public void testEntityWrapperSelect() {
        //我们需要分页查询tbl_Website表中，年龄在18~50之间且性别为男且姓名为Tom的所有用户

//		List<Website> emps =websiteMapper.selectPage(new Page<Website>(1, 2),
//					new EntityWrapper<Website>()
//					.between("age", 18, 50)
//					.eq("gender", 1)
//					.eq("last_name", "Tom")
//				);
//		System.out.println(emps);


        List<Website > emps = websiteMapper.selectPage(
                new Page<Website>(1,2),
                Condition.create()
                        .between("age", 18, 50)
                        .eq("gender", "1")
                        .eq("last_name", "Tom")

        );

        System.out.println(emps);





        // 查询tbl_Website表中， 性别为女并且名字中带有"老师" 或者  邮箱中带有"a"

//		List<Website> emps = websiteMapper.selectList(
//				new EntityWrapper<Website>()
//				.eq("gender", 0)
//				.like("last_name", "老师")
//				//.or()    // SQL: (gender = ? AND last_name LIKE ? OR email LIKE ?)
//				.orNew()   // SQL: (gender = ? AND last_name LIKE ?) OR (email LIKE ?)
//				.like("email", "a")
//				);
//		System.out.println(emps);


        // 查询性别为女的, 根据age进行排序(asc/desc), 简单分页

//		List<Website> emps  = websiteMapper.selectList(
//				new EntityWrapper<Website>()
//				.eq("gender", 0)
//				.orderBy("age")
//				//.orderDesc(Arrays.asList(new String [] {"age"}))
//				.last("desc limit 1,3")
//				);
//		System.out.println(emps);

    }



    /**
     * 通用 删除操作
     */
    @Test
    public void testCommonDelete() {
        //1 .根据id进行删除
        Integer result = websiteMapper.deleteById(13);
        System.out.println("result: " + result );
        //2. 根据 条件进行删除
//		Map<String,Object> columnMap = new HashMap<>();
//		columnMap.put("last_name", "MP");
//		columnMap.put("email", "mp@atguigu.com");
//		Integer result = websiteMapper.deleteByMap(columnMap);
//		System.out.println("result: " + result );

        //3. 批量删除
//		List<Integer> idList = new ArrayList<>();
//		idList.add(3);
//		idList.add(4);
//		idList.add(5);
//		Integer result = websiteMapper.deleteBatchIds(idList);
//		System.out.println("result: " + result );
    }

    /**
     * 通用 查询操作
     */
    @Test
    public void  testCommonSelect() {
        //1. 通过id查询
//		Website Website = websiteMapper.selectById(7);
//		System.out.println(Website);

        //2. 通过多个列进行查询    id  +  lastName
//		Website  Website = new Website();
//		//Website.setId(7);
//		Website.setLastName("小泽老师");
//		Website.setGender(0);
//
//		Website result = websiteMapper.selectOne(Website);
//		System.out.println("result: " +result );


        //3. 通过多个id进行查询    <foreach>
//		List<Integer> idList = new ArrayList<>();
//		idList.add(4);
//		idList.add(5);
//		idList.add(6);
//		idList.add(7);
//		List<Website> emps = websiteMapper.selectBatchIds(idList);
//		System.out.println(emps);

        //4. 通过Map封装条件查询
//		Map<String,Object> columnMap = new HashMap<>();
//		columnMap.put("last_name", "Tom");
//		columnMap.put("gender", 1);
//
//		List<Website> emps = websiteMapper.selectByMap(columnMap);
//		System.out.println(emps);

        //5. 分页查询
        List<Website> emps = websiteMapper.selectPage(new Page<>(3, 2), null);
        System.out.println(emps);
    }


    /**
     * 通用 更新操作
     */
    @Test
    public void testCommonUpdate() {
        //初始化修改对象
        Website Website = new Website();
//        Website.setId(7);
//        Website.setLastName("小泽老师");
//        Website.setEmail("xz@sina.com");
//        Website.setGender(0);
        //Website.setAge(33);

        //Integer result = websiteMapper.updateById(Website);
        Integer result = websiteMapper.updateAllColumnById(Website);

        System.out.println("result: " + result );
    }


    /**
     * 通用 插入操作
     */
    @Test
    public void testCommonInsert() {

        //初始化Website对象
        Website Website  = new Website();
//        Website.setLastName("MP");
//        Website.setEmail("mp@atguigu.com");
//        //Website.setGender(1);
//        //Website.setAge(22);
//        Website.setSalary(20000.0);
        //插入到数据库
        // insert方法在插入时， 会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
        //Integer result = websiteMapper.insert(Website);

        //insertAllColumn方法在插入时， 不管属性是否非空， 属性所对应的字段都会出现到SQL语句中.
        Integer result = websiteMapper.insertAllColumn(Website);

        System.out.println("result: " + result );

        //获取当前数据在数据库中的主键值
//        Integer key = Website.getId();
//        System.out.println("key:" + key );
    }


    @Test
    public void testDataSource() throws Exception {
//        DataSource ds  = ioc.getBean("dataSource",DataSource.class);
//        System.out.println(ds);
//        Connection conn = ds.getConnection();
//        System.out.println(conn);
    }
}
