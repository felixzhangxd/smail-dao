package biz.ezcom.smail.dao.api;

import biz.ezcom.smail.dao.po.ServerPo;

public interface IServerDao {
    int save(ServerPo po);

    int modifyById(ServerPo po);

    ServerPo findById(Integer id);

    ServerPo findByDomain(String domain);

}
