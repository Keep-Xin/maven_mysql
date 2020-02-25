package cn.codehut.dao.impl;

import cn.codehut.dao.ItemsDao;
import cn.codehut.domain.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author keep-xin
 * @date 2020/2/24-11:57
 */
public class ItemsDaoImpl implements ItemsDao {
    private static final String URL="jdbc:mysql://localhost:3306/maven";
    private static final String USERNAME="root";
    private static final String PWD="123456";

    public List<Items> findAll() throws Exception{
        List<Items> list=new ArrayList<Items>();
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            //导入驱动加载具体的驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //加载具体的驱动类
             connection = DriverManager.getConnection(URL,USERNAME,PWD);
             pst= connection.prepareCall("select * from items");
             rs=pst.executeQuery();
            while (rs.next()){
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                list.add(items);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            rs.close();
        }

        return  list;
    }
}
