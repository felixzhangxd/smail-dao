INSERT INTO t_server (id, domain, host, port) VALUES 
(1, '163.com', 'smtp.163.com', 25);
(2, '126.com', 'smtp.126.com', 25),

INSERT INTO t_mail_account (id, server_id, username, password, mailbox, is_useful) VALUES
(1, 1, 'huntersia', '1863970322', 'huntersia@163.com', 1);
(2, 2, 'huntersia', '1863970322', 'huntersia@126.com', 1),

