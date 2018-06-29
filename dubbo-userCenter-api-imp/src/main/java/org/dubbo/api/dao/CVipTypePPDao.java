package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;

public interface CVipTypePPDao {
    Integer getMemberTypeId(@Param("id") Integer id);
}