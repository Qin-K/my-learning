package com.qin_kai.netty.http;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qinkai
 * @date 2023/9/20
 */
@Component
@ConfigurationProperties(prefix = "http.server")
@Data
public class HttpServerProperties {

    /**
     * http端口
     */
    private Integer port = 8080;

    /**
     * 最大报文大小
     */
    private Integer maxLength = 5 * 1024 * 1024;

    /**
     * ssl证书相关配置
     */
    private Ssl ssl = new Ssl();

    @Data
    public static class Ssl {
        /**
         * 是否启用ssl
         */
        private boolean enable = false;
    }
}
