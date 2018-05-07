/*
 * Copyright 2014-2017 Aicai Group.
*/
package learn.ftp.test;

import com.aicai.filebus.sys.FtpParam;
import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

/**
 * Sftp工具类
 * @author yanglei
 * @date 2017/10/17 16:14
 */
@Slf4j
public class SftpChannel {
    private FtpParam param= null;
    private Session session = null;
    private Channel channel = null;

    public SftpChannel(FtpParam param){
        this.param = param;
    }

    public ChannelSftp getChannel(int timeout) throws JSchException {
        // 创建JSch对象
        JSch jsch = new JSch();
        // 根据用户名，主机ip，端口获取一个Session对象
        session = jsch.getSession(param.getUser(), param.getServer(), param.getPort());
        log.debug("Session created.");
        if (StringUtils.isNotBlank(param.getPassword())) {
            // 设置密码
            session.setPassword(param.getPassword());
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        // 为Session对象设置properties
        session.setConfig(config);
        // 设置timeout时间
        session.setTimeout(timeout);
        // 通过Session建立链接
        session.connect();
        log.debug("Session connected.");

        log.debug("Opening Channel.");
        // 打开SFTP通道
        channel = session.openChannel("sftp");
        channel.connect(); // 建立SFTP通道的连接
        log.debug("Connected successfully to ftpHost = " + param.getServer() + ",as ftpUserName = " + param.getUser() + ", returning: " + channel);
        return (ChannelSftp) channel;
    }

    public void closeChannel() throws Exception {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }
}
