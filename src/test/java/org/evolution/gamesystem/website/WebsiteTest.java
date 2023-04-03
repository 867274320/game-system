package org.evolution.gamesystem.website;


import org.evolution.modules.website.entities.Website;
import org.evolution.modules.website.mapper.WebsiteMapper;
import org.evolution.util.IdWorker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WebsiteTest {

    @Autowired
    private WebsiteMapper websiteMapper;


    @Test
    public void updateAllId() {
//        IdWorker worker = new IdWorker(1,1,1);
//        List<Website> websites = websiteMapper.selectList(null);
//        for (Website website:websites) {
//            Long rowId = website.getRowId();
//            Long targetRowId = worker.nextId();
//            websiteMapper.myUpdateById(targetRowId,rowId);
//        }

    }

    @Test
    public void testSelect() {
        List<Website> websites = websiteMapper.selectList(null);
        for (Website website:websites) {
            System.out.println(website);
        }

    }


    @Test
    public void testInsert() {
//        IdWorker worker = new IdWorker(1,1,1);
//        Website website = new Website();
//        website.setRowId(worker.nextId());
////        website.setPlatformName("极客云");
//        website.setAccountName("");
//        website.setVersion("0");
//        websiteMapper.insert(website);
    }
}
