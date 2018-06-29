package org.dubbo.api.dao;

import org.dubbo.pojo.dto.error.ErrorDataDto;

import java.util.List;

/**
 * Created by fanglei on 2018/5/17.
 */
public interface ErrorDataDao {

    List<ErrorDataDto> getErrorDateList();
}
