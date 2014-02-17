package biz.ezcom.smail.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import biz.ezcom.smail.dao.api.IMailAccountDao;
import biz.ezcom.smail.dao.po.MailAccountPo;

@Repository
public class MailAccountDao implements IMailAccountDao {
    @Resource
    private JdbcTemplate             jdbcTemplate;
    private RowMapper<MailAccountPo> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(MailAccountPo.class);

    @Override
    public int save(final MailAccountPo po) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int affect = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "INSERT INTO t_mail_account (server_id,username,password,mailbox,is_useful) VALUES (?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, po.getServerId());
                ps.setString(2, po.getUsername());
                ps.setString(3, po.getPassword());
                ps.setString(4, po.getMailbox());
                ps.setBoolean(5, po.getIsUseful());
                return ps;
            }
        }, keyHolder);
        po.setId(keyHolder.getKey().intValue());
        return affect;
    }

    @Override
    public List<MailAccountPo> findByServerId(Integer serverId) {
        String sql = "SELECT * FROM t_mail_account WHERE is_useful=? AND server_id=?";
        Object[] args = new Object[] { true, serverId };
        return jdbcTemplate.query(sql, args, rowMapper);
    }
}
