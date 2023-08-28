package com.qin_kai.springboot.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinkai
 * @date 2023/8/28
 */
@RestController
public class TestController {

    /**
     * 使用@Valud注解的配置可以自动注入
     */
    @Value("${test}")
    private String test;

    @GetMapping("/test")
    public String test() {
        return test;
    }

    @GetMapping("/get")
    public String get(String key) {
        // api使用获取配置
        Config appConfig = ConfigService.getAppConfig();
        return appConfig.getProperty(key, null);
    }

    @Autowired
    private TestProperties testProperties;

    @GetMapping("/getTest")
    public TestProperties getTest() {
        return testProperties;
    }


}
