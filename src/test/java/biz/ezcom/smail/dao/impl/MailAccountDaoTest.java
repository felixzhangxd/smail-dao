package biz.ezcom.smail.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.ezcom.smail.dao.api.IMailAccountDao;
import biz.ezcom.smail.dao.po.MailAccountPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/applicationContext-*.xml")
public class MailAccountDaoTest {
    @Resource
    private IMailAccountDao mailAccountDao;
    
    @Test
    public void testSave() {
        MailAccountPo po = new MailAccountPo();
        po.setServerId(1);
        po.setUsername("huntersia");
        po.setPassword("1863970322");
        po.setMailbox("huntersia@126.com");
        po.setIsUseful(true);
        int effect = mailAccountDao.save(po);
        Assert.assertEquals(1, effect);
    }
    
    @Test
    public void testFindByServerId() {
        Integer serverId = 1;
        MailAccountPo po = new MailAccountPo();
        po.setId(1);
        po.setServerId(serverId);
        po.setUsername("huntersia");
        po.setPassword("1863970322");
        po.setMailbox("huntersia@126.com");
        po.setIsUseful(true);
        List<MailAccountPo> poInDbs = mailAccountDao.findByServerId(serverId);
        Assert.assertEquals(po, poInDbs.get(0));
    }
}
