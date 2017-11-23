package org.smart4j.chapter2.service;

import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by admin on 2017/11/22
 * 提供客户数据服务.
 */
public class CustomerService {

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties conf= PropsUtil.loadProps("config.properties");
        DRIVER=conf.getProperty("jdbc.driver");
        URL=conf.getProperty("jdbc.url");
        USERNAME=conf.getProperty("jdbc.username");
        PASSWORD=conf.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            PropsUtil.LOGGER.error("can not load jdbc driver",e);
        }
    }

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList(){
        Connection conn=null;
        List<Customer> customerList=new ArrayList<Customer>();
        try {

            String sql="SELECT * FROM customer";
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            PreparedStatement stmt= conn.prepareCall(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()){
                Customer c=new Customer();
                c.setId(rs.getLong("id"));
                c.setName(rs.getString("name"));
                c.setContact(rs.getString("contact"));
                c.setTelephone(rs.getString("telephone"));
                c.setEmail(rs.getString("email"));
                c.setRemark(rs.getString("remark"));
                customerList.add(c);
            }
        }catch (SQLException e){
            PropsUtil.LOGGER.error("excute sql failure",e);
        }finally {
            if(conn!=null){
                try {
                    conn.close();
            }catch(SQLException e){
                    PropsUtil.LOGGER.error("can not load jdbc driver",e);
                }
            }
        }
        return  customerList;
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id){
        return  null;
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        return  false;
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(Map<String,Object> fieldMap){
        return  false;
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id){
        return  false;
    }
}
