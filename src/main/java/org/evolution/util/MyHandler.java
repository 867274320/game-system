package org.evolution.util;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

public class MyHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("====");
        this.setFieldValByName("createDate",new Date(),metaObject);
        this.setFieldValByName("updateDate",new Date(),metaObject);
        this.setFieldValByName("version","0",metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateDate",new Date(),metaObject);
    }
}
