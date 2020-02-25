package cn.codehut.test;

import cn.codehut.dao.ItemsDao;
import cn.codehut.dao.impl.ItemsDaoImpl;
import cn.codehut.domain.Items;
import org.junit.Test;

import java.util.List;

/**
 * @author keep-xin
 * @date 2020/2/24-12:20
 */

public class ItemsTest {
    @Test
    public void findAll() throws Exception {
        ItemsDao itemsDao=new ItemsDaoImpl();
        List<Items> list=itemsDao.findAll();
        for (Items items:list) {
            System.out.println(items.getName()+items.getId());
        }

    }
}
