package qinkai.spring.demo1;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspectAnno {

    @Before(value = "execution(* qinkai.spring.demo1.OrderDao.save(..))")
    public void checkPri() {
        System.out.println("权限校验=============");
    }

    @AfterReturning("MyAspectAnno.pointcut1()")
    public void afterReturning() {
        System.out.println("后置增强============");
    }

    // 切入点配置
    @Pointcut("execution(* qinkai.spring.demo1.OrderDao.update(..))")
    public void pointcut1() {
    }
}
