package com.qin_kai.springtest.advancedassemblies.conflict;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
@Component("myIceCream")
public class IceCream implements Dessert {
}
