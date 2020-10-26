package com.qin_kai.shiro.service;

import com.qin_kai.shiro.model.UserInfo;
import com.qin_kai.shiro.repository.UserInfoRepository;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qinkai
 * @date 2020/10/26
 */
@Service
public class UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }

    public void register(UserInfo userInfo) {
        userInfo.setSalt("123");
        ByteSource bytes = ByteSource.Util.bytes(userInfo.getCredentialsSalt());
        String passwordMd5 = new SimpleHash("md5", userInfo.getPassword(), bytes, 2).toHex();
        userInfo.setPassword(passwordMd5);
        userInfoRepository.save(userInfo);
    }
}
