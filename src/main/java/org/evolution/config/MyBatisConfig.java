package org.evolution.config;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.evolution.util.MyHandler;
import org.evolution.util.MySqlInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private GlobalConfiguration globalConfiguration;

    @Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean () {
        MybatisSqlSessionFactoryBean mybatisSqlFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlFactoryBean.setDataSource(dataSource);

        /*定义MybatisPlus的全局策略配置*/
        mybatisSqlFactoryBean.setGlobalConfig(globalConfiguration);


        /*注册执行分析插件*/
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        sqlExplainInterceptor.setStopProceed(true);

        /*注册分页插件*/
        Interceptor[] interceptors = new Interceptor[]{
                new PaginationInterceptor(),sqlExplainInterceptor
        };

        /*PerformanceInterceptor注册性能分析插件 <!-- <property name="maxTime" value="5"></property> -->*/
        /*OptimisticLockerInterceptor注册乐观锁插件*/

        mybatisSqlFactoryBean.setPlugins(interceptors);


        return mybatisSqlFactoryBean;
    }

    @Bean
    public GlobalConfiguration globalConfiguration () {
        GlobalConfiguration global = new GlobalConfiguration();

        global.setDbColumnUnderline(true);

        /*注入自定义全局操作 */
        global.setSqlInjector(new MySqlInjector());
        global.setMetaObjectHandler(new MyHandler());
        return global;
    }
}
