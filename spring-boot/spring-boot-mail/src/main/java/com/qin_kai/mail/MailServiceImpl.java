package com.qin_kai.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author qin kai
 * @date 2020/8/28
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    @Value("${mail.from.addr}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            LOGGER.info("邮件已经发送, to={}, subject={}", to, subject);
        } catch (MailException e) {
            LOGGER.error("邮件发送异常!", e);
        }
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(mimeMessage);

            LOGGER.info("发送html格式的邮件成功!");
        } catch (MessagingException e) {
            LOGGER.error("发送html格式的邮件失败!", e);
        }

    }

    @Override
    public void sendAttachMentsMail(String to, String subject, String content, File file) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.addAttachment(file.getName(), file);
            helper.setText(content, true);
            mailSender.send(mimeMessage);

            LOGGER.info("发送带附加你的邮件成功!");
        } catch (MessagingException e) {
            LOGGER.error("发送带附加你的邮件失败!", e);
        }
    }
}
