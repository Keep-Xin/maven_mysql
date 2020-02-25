package cn.codehut.dao;

import cn.codehut.domain.Items;

import java.util.List;

/**
 * @author keep-xin
 * @date 2020/2/24-11:55
 */
public interface ItemsDao {
    public List<Items> findAll() throws Exception;
}
