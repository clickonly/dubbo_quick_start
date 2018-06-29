package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.user.Customer;

public interface CustomerDao {

    Customer getCustomer(@Param("unionid") String unionid);

    void insertCustomer(Customer customer);

    String getCustomerNo();
}