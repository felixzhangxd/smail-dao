package biz.ezcom.smail.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import biz.ezcom.smail.dao.api.IMailboxDao;
import biz.ezcom.smail.dao.po.MailboxPo;

@Repository
public class MailboxDao implements IMailboxDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int[] save(final List<MailboxPo> mailboxes) {
        if (mailboxes == null || mailboxes.isEmpty()) {
            return new int[0];
        }
        String sql = "INSERT IGNORE INTO t_mailbox (server_id,username,vrfy_date) VALUES (?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                MailboxPo mailbox = mailboxes.get(i);
                ps.setInt(1, mailbox.getServerId());
                ps.setString(2, mailbox.getUsername());
                ps.setDate(3, mailbox.getVrfyDate());
            }

            @Override
            public int getBatchSize() {
                return mailboxes.size();
            }
        });
    }
}
