package biz.ezcom.smail.dao.api;

import java.util.List;

import biz.ezcom.smail.dao.po.MailboxPo;

public interface IMailboxDao {
    int[] save(List<MailboxPo> mailboxes);
}
