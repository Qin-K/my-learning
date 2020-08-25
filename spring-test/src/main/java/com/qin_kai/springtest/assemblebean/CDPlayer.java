package com.qin_kai.springtest.assemblebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @Date 2020/8/24
 */
//@Component
public class CDPlayer {

    // 自动装配
//    @Autowired
    private CompactDisc compactDisc;

    // 构造方法
//    @Autowired
    public  CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }

    // set 方法
//    @Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }
}
