package com.qin_kai.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("1547127079@qq.com", "测试邮件", "测试邮件");
    }

    @Test
    void sendHtmlMail() {
        String content = "<html><body><h1>测试邮件</h1><p><font color='red'>测试邮件</font></p></body></html>";
        mailService.sendHtmlMail("1547127079@qq.com", "测试 html 邮件", content);
    }

    @Test
    void sendAttachMentsMail() {
        String path = MailServiceImplTest.class.getClassLoader().getResource("test.txt").getPath();
        File file = new File(path);
        mailService.sendAttachMentsMail("1547127079@qq.com", "测试 html 邮件", "测试带附件的邮件", file);
    }
}