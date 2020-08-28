package com.qin_kai.mail;

import java.io.File;

/**
 * @author qin kai
 * @Date 2020/8/28
 */
public interface MailService {

    /**
     * 发送简单邮箱
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送 html 格式的邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject,String content);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param file
     */
    void sendAttachMentsMail(String to, String subject, String content, File file);
}
