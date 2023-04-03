package org.evolution.modules.website.controller;


import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import org.evolution.modules.website.entities.Website;
import org.evolution.modules.website.service.impl.WebsiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tanglijie
 * @since 2023-03-13
 */
@Controller
@RequestMapping("/website")
public class WebsiteController {

    @Autowired
    private WebsiteServiceImpl websiteService;

    @ResponseBody
    @RequestMapping(value = "/queryExamplePage")
    public HashMap<String,Object> queryExamplePage(HttpServletRequest request) {  // 这里有分页参数  实例参数
        HashMap hashMap = new HashMap();
        try {
            String curPage =  request.getParameter("curPage");
            String pageSize =  request.getParameter("pageSize");
            Page<Website> websitePage = new Page<>(Integer.valueOf(curPage), Integer.valueOf(pageSize));
            Condition condition = Condition.create();
            condition.orderBy("create_date",false);
            Page<Website> websites = websiteService.selectPage(websitePage,condition);
            hashMap.put("code",200);
            hashMap.put("success","true");
            hashMap.put("data",websites);
        } catch (Exception e) {
            hashMap.put("success","false");
            hashMap.put("code",200);
            hashMap.put("data",e.getMessage());
        }
        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/create")
    public HashMap<String,Object> create(Website website) {  // 这里有分页参数  实例参数
        HashMap hashMap = new HashMap();
        try {
            website.setRowId(IdWorker.getId());
            websiteService.insertAllColumn(website);
            hashMap.put("code",200);
            hashMap.put("success","true");
        } catch (Exception e) {
            hashMap.put("success","false");
            hashMap.put("code",200);
            hashMap.put("data",e.getMessage());
        }
        return hashMap;
    }
}

