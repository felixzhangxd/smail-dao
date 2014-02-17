package biz.ezcom.smail.dao.po;

public class ServerPo {
    private Integer id;
    private String  domain;
    private String  host;
    private Integer port;

    public ServerPo() {}

    public ServerPo(Integer id, String domain, String host, Integer port) {
        this.id = id;
        this.domain = domain;
        this.host = host;
        this.port = port;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ServerPo server = (ServerPo) obj;
        if (!this.getId().equals(server.getId())) {
            return false;
        }
        if (!this.getDomain().equals(server.getDomain())) {
            return false;
        }
        if (!this.getHost().equals(server.getHost())) {
            return false;
        }
        if (!this.getPort().equals(server.getPort())) {
            return false;
        }
        return true;
    }
}
