package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.user.EmployeeBase;

public interface EmployeeBaseDao {

    EmployeeBase getLinkstoreByEm(@Param("id") int id);
}