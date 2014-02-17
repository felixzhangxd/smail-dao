package biz.ezcom.smail.dao.api;

import java.util.List;

import biz.ezcom.smail.dao.po.MailAccountPo;

public interface IMailAccountDao {
    int save(MailAccountPo po);

    List<MailAccountPo> findByServerId(Integer serverId);
}
