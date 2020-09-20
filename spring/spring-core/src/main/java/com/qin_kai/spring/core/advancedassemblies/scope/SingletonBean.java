package com.qin_kai.spring.core.advancedassemblies.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @Date 2020/8/25
 */

@Component
/**
 * Scope 指定作用域 默认 "" 相当于 SCOPE_SINGLETON 单例
 * ConfigurableBeanFactory#SCOPE_PROTOTYPE 原型 每次创建
 * ConfigurableBeanFactory#SCOPE_SINGLETON 单例
 * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST web应用 每个请求
 * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION web应用 每个会话
 */
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonBean {
}
