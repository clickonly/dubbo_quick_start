package org.dubbo.config;

import org.apache.log4j.Logger;
import org.dubbo.audience.ActivityActionConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by jinpan12430 on 2018/1/22.
 */

@Component
public class AspectJOpenConfig {

    @Bean
    public ActivityActionConfig ActivityActionConfig(){
        return new ActivityActionConfig();
    }

}
