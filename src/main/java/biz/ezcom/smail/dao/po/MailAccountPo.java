package biz.ezcom.smail.dao.po;

public class MailAccountPo {
    private Integer id;
    private Integer serverId;
    private String  username;
    private String  password;
    private String  mailbox;
    private Boolean isUseful;

    public MailAccountPo() {}

    public MailAccountPo(Integer id, Integer serverId, String username, String password, String mailbox, Boolean isUseful) {
        this.id = id;
        this.serverId = serverId;
        this.username = username;
        this.password = password;
        this.mailbox = mailbox;
        this.isUseful = isUseful;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public Boolean getIsUseful() {
        return isUseful;
    }

    public void setIsUseful(Boolean isUseful) {
        this.isUseful = isUseful;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        MailAccountPo account = (MailAccountPo) obj;
        if (!this.getId().equals(account.getId())) {
            return false;
        }
        if (!this.getServerId().equals(account.getServerId())) {
            return false;
        }
        if (!this.getUsername().equals(account.getUsername())) {
            return false;
        }
        if (!this.getPassword().equals(account.getPassword())) {
            return false;
        }
        if (!this.getMailbox().equals(account.getMailbox())) {
            return false;
        }
        if (!this.getIsUseful().equals(account.getIsUseful())) {
            return false;
        }
        return true;
    }
}
