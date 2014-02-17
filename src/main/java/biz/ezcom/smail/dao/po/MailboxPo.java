package biz.ezcom.smail.dao.po;

import java.sql.Date;

public class MailboxPo {
    private Integer id;
    private Integer serverId;
    private String  username;
    private Date    vrfyDate;

    public MailboxPo() {}

    public MailboxPo(Integer id, Integer serverId, String username, Date vrfyDate) {
        this.id = id;
        this.serverId = serverId;
        this.username = username;
        this.vrfyDate = vrfyDate;
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

    public Date getVrfyDate() {
        return vrfyDate;
    }

    public void setVrfyDate(Date vrfyDate) {
        this.vrfyDate = vrfyDate;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        MailboxPo mailbox = (MailboxPo) obj;
        if (!this.getId().equals(mailbox.getId())) {
            return false;
        }
        if (!this.getServerId().equals(mailbox.getServerId())) {
            return false;
        }
        if (!this.getUsername().equals(mailbox.getUsername())) {
            return false;
        }
        if (!this.getVrfyDate().equals(mailbox.getVrfyDate())) {
            return false;
        }
        return true;
    }
}
