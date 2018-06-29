package org.dubbo.pojo.dto.activity;

import java.util.List;

/**
 * Created by fanglei on 2018/6/6.
 */
public class PrizeRecordDto extends ActivityDto {

    private List activityIdList;

    public List getActivityIdList() {
        return activityIdList;
    }

    public void setActivityIdList(List activityIdList) {
        this.activityIdList = activityIdList;
    }
}
