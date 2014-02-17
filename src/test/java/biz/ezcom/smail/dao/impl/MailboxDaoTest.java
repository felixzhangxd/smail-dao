package biz.ezcom.smail.dao.impl;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.ezcom.smail.dao.api.IMailboxDao;
import biz.ezcom.smail.dao.po.MailboxPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/applicationContext-*.xml")
public class MailboxDaoTest {
    @Resource
    private IMailboxDao mailboxDao;

    @Test
    public void testSave() {
        List<MailboxPo> poes = new LinkedList<MailboxPo>();
        for (int i = 0; i < 10; i++) {
            MailboxPo po = new MailboxPo();
            po.setServerId(1);
            po.setUsername("a_" + i);
            po.setVrfyDate(new Date(System.currentTimeMillis()));
            poes.add(po);
        }
        mailboxDao.save(poes);
    }
}
