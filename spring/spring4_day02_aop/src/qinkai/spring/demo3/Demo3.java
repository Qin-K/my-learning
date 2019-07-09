package qinkai.spring.demo3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo3 {
    @Resource(name = "productDao")
    private ProductDao productDao;

    @Test
    public void demo1() {
        productDao.save();
        productDao.find();
        productDao.update();
        productDao.delete();
    }
}
