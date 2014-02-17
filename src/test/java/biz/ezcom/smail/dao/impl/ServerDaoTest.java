package biz.ezcom.smail.dao.impl;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.ezcom.smail.dao.api.IServerDao;
import biz.ezcom.smail.dao.po.ServerPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/applicationContext-*.xml")
public class ServerDaoTest {
    @Resource
    private IServerDao serverDao;
    
    @Test
    public void testSave() {
        ServerPo po = new ServerPo();
        po.setDomain("163.com");
        po.setHost("smtp.163.com");
        po.setPort(26);
        int effect = serverDao.save(po);
        Assert.assertEquals(1, effect);
    }
    @Test
    public void testModifyById() {
        ServerPo po = new ServerPo();
        po.setId(1);
        po.setDomain("126.com");
        po.setHost("smtp.126.com");
        po.setPort(25);
        int effect = serverDao.modifyById(po);
        Assert.assertEquals(1, effect);
    }
    
    @Test
    public void testFindById() {
        ServerPo server = new ServerPo();
        server.setId(1);
        server.setDomain("126.com");
        server.setHost("smtp.126.com");
        server.setPort(25);
        ServerPo po = serverDao.findById(1);
        Assert.assertEquals(server, po);
    }
    
    @Test
    public void testFindByDomain() {
        ServerPo server = new ServerPo();
        server.setId(1);
        server.setDomain("126.com");
        server.setHost("smtp.126.com");
        server.setPort(25);
        ServerPo po = serverDao.findByDomain("126.com");
        Assert.assertEquals(server, po);
    }
}
