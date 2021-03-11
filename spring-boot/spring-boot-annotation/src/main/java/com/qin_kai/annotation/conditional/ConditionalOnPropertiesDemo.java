package com.qin_kai.annotation.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author qinkai
 * @date 2020/11/25
 */
@Component
@ConditionalOnProperty(prefix = "conditional.test", name = "enable", havingValue = "true")
public class ConditionalOnPropertiesDemo {

}
