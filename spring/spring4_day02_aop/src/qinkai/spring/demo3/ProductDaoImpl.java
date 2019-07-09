package qinkai.spring.demo3;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void save() {
        System.out.println("保存商品");
    }

    @Override
    public void find() {
        System.out.println("查询商品");
    }

    @Override
    public void update() {
        System.out.println("修改商品");
    }

    @Override
    public void delete() {
        System.out.println("删除商品");
    }

}
