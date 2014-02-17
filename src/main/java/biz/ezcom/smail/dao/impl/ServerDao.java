package biz.ezcom.smail.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import biz.ezcom.smail.dao.api.IServerDao;
import biz.ezcom.smail.dao.po.ServerPo;

@Repository
public class ServerDao implements IServerDao {
    @Resource
    private JdbcTemplate        jdbcTemplate;
    private RowMapper<ServerPo> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(ServerPo.class);

    @Override
    public int save(final ServerPo po) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int affect = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "INSERT INTO t_server (domain,host,port) VALUES (?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, po.getDomain());
                ps.setString(2, po.getHost());
                ps.setInt(3, po.getPort());
                return ps;
            }
        }, keyHolder);
        po.setId(keyHolder.getKey().intValue());
        return affect;
    }

    @Override
    public int modifyById(final ServerPo po) {
        String sql = "UPDATE t_server SET domain=?,host=?,port=? WHERE id=?";
        Object[] args = new Object[] { po.getDomain(), po.getHost(), po.getPort(), po.getId() };
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public ServerPo findById(Integer id) {
        String sql = "SELECT * FROM t_server WHERE id=" + id;
        return (ServerPo) jdbcTemplate.queryForObject(sql, rowMapper);
    }

    @Override
    public ServerPo findByDomain(String domain) {
        String sql = "SELECT * FROM t_server WHERE domain=?";
        return (ServerPo) jdbcTemplate.queryForObject(sql, new Object[] { domain }, rowMapper);
    }
}
