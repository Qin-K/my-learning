package com.qin_kai.spring.core.advancedassemblies.valueinjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author qin kai
 * @date 2020/8/25
 */
@Component
public class SpEL {
    @Value("#{3.14159}")
    private float f;

    @Value("#{'hello'}")
    private String s;

    @Value("#{false}")
    private boolean b;

    @Value("#{user.name}")
    private String userName;

    @Value("#{T(System).currentTimeMillis()}")
    private long timestamp;

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SpEL{" +
                "f=" + f +
                ", s='" + s + '\'' +
                ", b=" + b +
                ", userName='" + userName + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
